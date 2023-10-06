package com.logistic.controller;

import com.logistic.domain.CcClientes;
import com.logistic.service.CcClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/logistic/client")
public class CcClientesController {

    private final CcClientesService ccClientesService;


    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('user:create')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CcClientes> create(@RequestBody CcClientes cliente) {
        return new ResponseEntity<>(ccClientesService.registClient(cliente), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('user:update')")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CcClientes> updateCliente(@PathVariable(name = "id") Long id, @RequestBody CcClientes cliente) {
        return ResponseEntity.ok(ccClientesService.updateClient(id, cliente));
    }

    @GetMapping(value = "/findby", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('user:read')")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CcClientes>> findByFilters(
            @RequestParam(value = "name", required = false) String names,
            @RequestParam(value = "lastname", required = false) String lastname,
            @RequestParam(value = "telefono", required = false) String telefono,
            @RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>(ccClientesService.findByFilters(names,lastname,telefono), HttpStatus.OK);
    }


}
