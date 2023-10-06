package com.logistic.service;

import com.logistic.domain.CcTransporte;

import java.util.List;

public interface CcTransporteService {
    List<CcTransporte> findAllAvailable();
    CcTransporte registVehiculo(CcTransporte vehiculo);

    CcTransporte darDeBaja(Long id);
}
