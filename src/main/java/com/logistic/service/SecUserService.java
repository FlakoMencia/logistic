package com.logistic.service;

import com.logistic.domain.dto.UserDto;
import com.logistic.domain.dto.UserNewDto;

import java.util.List;
import java.util.Optional;

public interface SecUserService {

    List<UserDto> findAllForAdmin();

    UserDto createNewUser(UserNewDto userNewDto);

    Optional<UserDto> activateUser(String userName);
}
