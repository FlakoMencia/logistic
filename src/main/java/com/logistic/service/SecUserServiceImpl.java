package com.logistic.service;


import com.logistic.config.SecurityHelper;
import com.logistic.domain.SecUser;
import com.logistic.domain.dto.UserDto;
import com.logistic.domain.dto.UserNewDto;
import com.logistic.repository.SecUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SecUserServiceImpl implements SecUserService {
    private final SecUserRepository secUserRepository;
    private final PasswordEncoder passwordEncoder;

    public SecUserServiceImpl(SecUserRepository secUserRepository, PasswordEncoder passwordEncoder) {
        this.secUserRepository = secUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDto> findAllForAdmin() {
        List<SecUser> secUsers = secUserRepository.findAll();

        return secUsers.stream().map(this::convertSecUserToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto createNewUser(UserNewDto userNewDto) {
        Optional<SecUser> secUsersByCdUser = secUserRepository.findSecUsersByCdUser(userNewDto.getUserName());
        if(secUsersByCdUser.isPresent()){
            return convertSecUserToDto(secUsersByCdUser.get());
        }
        SecUser userNew = new SecUser();
        userNew.setCdUser(userNewDto.getUserName());
        userNew.setStEmail(userNewDto.getUserEmail());
        userNew.setStPassword(passwordEncoder.encode(userNewDto.getPassword()));
        userNew.setIsActive(false);
        userNew.setDtCreate(new Date());
        secUserRepository.save(userNew);
        return convertSecUserToDto(userNew);
    }

    @Override
    public Optional<UserDto> activateUser(String userName) {
        Optional<SecUser> userToActivate =  secUserRepository.findSecUsersByCdUser(userName);
        if(userToActivate.isPresent()){
            userToActivate.get().setIsActive(true);
            userToActivate.get().setStCreUser(SecurityHelper.getLoggedInUserDetails().getCduser());
            secUserRepository.save(userToActivate.get());
            return Optional.of(convertSecUserToDto(userToActivate.get()));
        }
        return Optional.empty();
    }


    private UserDto convertSecUserToDto(SecUser secUser) {
        UserDto dto = new UserDto();
        dto.setUserId(secUser.getIdUser());
        dto.setUserName(secUser.getCdUser());
        dto.setUserEmail(secUser.getStEmail());
        dto.setUserStatus(secUser.getIsActive() ? "Active" : "Deactivate");

        return dto;
    }
}
