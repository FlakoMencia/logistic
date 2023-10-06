package com.logistic.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        if(SecurityHelper.getLoggedInUserDetails() != null) {
            return Optional.of(SecurityHelper.getLoggedInUserDetails().getUsername());
        }
        else return Optional.empty();
    }
}
