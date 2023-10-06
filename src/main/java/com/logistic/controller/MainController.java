package com.logistic.controller;

import com.logistic.domain.dto.UserDto;
import com.logistic.domain.dto.UserNewDto;
import com.logistic.service.SecUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ingeneo")
public class MainController {

    private final SecUserService secUserService;
    public MainController(SecUserService secUserService){
        this.secUserService = secUserService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> areWeAlive() {
        String alive = "We stand Alive, (Hello from Mario Mencia - Ingeneo Test )";
        return ResponseEntity.ok(alive);
    }


    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDto> createUser(
            @RequestBody @Validated UserNewDto userNewDto
    ) {
        return new ResponseEntity<>(secUserService.createNewUser(userNewDto), HttpStatus.CREATED);
    }
}
