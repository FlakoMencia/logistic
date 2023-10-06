package com.logistic.controller;

import com.logistic.domain.CcBodega;
import com.logistic.service.CcBodegaService;
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
@RequestMapping("/api/logistic/warehouse")
public class CcBodegaController {


    private final CcBodegaService ccBodegaService ;


    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CcBodega>> getBodegaList() {
        return new ResponseEntity<>(ccBodegaService.findAllAvailable(),HttpStatus.OK);
    }
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('user:create')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CcBodega> create(@RequestBody @Validated CcBodega bodega) {
        return new ResponseEntity<>(ccBodegaService.registBodega(bodega), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('user:delete')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable(name = "id") Long id) {
        ccBodegaService.delete(id);
    }

}
