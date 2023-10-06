package com.logistic.service;

import com.logistic.common.Role;
import com.logistic.config.SecurityUserDetails;
import com.logistic.domain.SecUser;
import com.logistic.repository.SecUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SecUserRepository secUserRepository;

    public UserDetailsServiceImpl(SecUserRepository secUserRepository) {
        this.secUserRepository = secUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SecUser> userOptional = secUserRepository.findSecUsersByCdUser(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(username + " Not Found");
        }
        SecUser user = userOptional.orElse(new SecUser());
        if (!user.getIsActive()) {
            throw new UsernameNotFoundException(username + " Not Available");
        }
        SecurityUserDetails securityUser = new SecurityUserDetails();
        securityUser.setCduser(user.getCdUser());
        securityUser.setPassword(user.getStPassword());
        securityUser.setIsEnable(user.getIsActive());
        securityUser.setRole(loadRoleBySecUserRole(user).orElse(Role.USER));

        return securityUser;
    }

    private Optional<Role> loadRoleBySecUserRole(SecUser user) {
        Optional<Role> role = Optional.ofNullable(user.getSecUserRoles())
                .map(roles -> roles.stream()
                        .filter(userRole -> Objects.equals("ADMIN",
                                userRole.getSecRoleByFkRole().getCdRole()) &&
                                userRole.getSecRoleByFkRole().getIsActive())
                        .map(userRole -> Role.ADMIN)
                        .findFirst()
                ).orElse(null);
        return role;
    }
}
