package com.logistic.service;

import com.logistic.domain.CcPuerto;

import java.util.List;

public interface CcPuertoService {


    List<CcPuerto> findAllAvailable();
    CcPuerto registPuerto(CcPuerto bodega);

    void delete(Long id);
}
