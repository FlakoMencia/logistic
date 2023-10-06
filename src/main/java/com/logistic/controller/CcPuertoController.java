package com.logistic.controller;

import com.logistic.domain.CcPuerto;
import com.logistic.service.CcPuertoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/logistic/seaports")
public class CcPuertoController {


    private final CcPuertoService ccPuertoService ;


    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CcPuerto>> getPuertoList() {
        return new ResponseEntity<>(ccPuertoService.findAllAvailable(),HttpStatus.OK);
    }
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('user:create')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CcPuerto> create(@RequestBody @Validated CcPuerto puerto) {
        return new ResponseEntity<>(ccPuertoService.registPuerto(puerto), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('user:delete')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable(name = "id") Long id) {
        ccPuertoService.delete(id);
    }

}
