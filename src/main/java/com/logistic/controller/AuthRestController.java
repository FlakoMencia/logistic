package com.logistic.controller;

import com.logistic.config.dto.AuthResponse;
import com.logistic.config.dto.JwtRequest;
import com.logistic.config.jwt.JwtTokenUtil;
import com.logistic.service.UserDetailsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthRestController {
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthRestController(UserDetailsServiceImpl userDetailsService, JwtTokenUtil jwtTokenUtil){
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;

    }


    @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) {

        String username = authenticationRequest.getUsername();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        AuthResponse response = new AuthResponse();
        if (userDetails != null && userDetails.isEnabled() ) {
            final String token = jwtTokenUtil.generateToken(userDetails);
            response.setId(1);
            response.setUser(authenticationRequest.getUsername());
            response.setAccess_token(token);
            return ResponseEntity.ok(response);
        }
        response.setUser(username);
        response.setAccess_token("-1");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}