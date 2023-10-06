package com.logistic.controller;

import com.logistic.domain.dto.UserDto;
import com.logistic.service.SecUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingeneo/admin")
@PreAuthorize("hasRole('ADMIN')")
public class SecUserController {

    private final SecUserService secUserService;
    public SecUserController(SecUserService secUserService){
        this.secUserService = secUserService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDto>> getUserList() {
        return new ResponseEntity<>(secUserService.findAllForAdmin(),HttpStatus.OK);
    }

    @PatchMapping(value = "/activate/user",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('admin:update')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<UserDto> activateUser(
            @RequestBody UserDto userName
    ) {
        UserDto notFound = new UserDto();
        notFound.setUserName("User not Found");
        return secUserService.activateUser(userName.getUserName())
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(notFound, HttpStatus.NOT_FOUND));
    }
}
