package com.logistic.controller;

import com.logistic.domain.CcTransporte;
import com.logistic.service.CcTransporteService;
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
@RequestMapping("/api/logistic/vehiculo")
public class CcTransporteController {

    private final CcTransporteService ccTransporteService;




    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CcTransporte>> getVehiculosList() {
        return new ResponseEntity<>(ccTransporteService.findAllAvailable(),HttpStatus.OK);
    }
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('user:create')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CcTransporte> create(@RequestBody @Validated CcTransporte vehiculo) {
        return new ResponseEntity<>(ccTransporteService.registVehiculo(vehiculo), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('user:delete')")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<CcTransporte> darDeBaja(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(ccTransporteService.darDeBaja(id));
    }


}
