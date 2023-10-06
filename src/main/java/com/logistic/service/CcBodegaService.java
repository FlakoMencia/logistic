package com.logistic.service;

import com.logistic.domain.CcBodega;

import java.util.List;

public interface CcBodegaService {
    CcBodega registBodega(CcBodega bodega);

    List<CcBodega> findAllAvailable();

    void delete(Long id);
}
