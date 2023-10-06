package com.logistic.service;

import com.logistic.domain.CcClientes;

import java.util.List;

public interface CcClientesService {
    CcClientes registClient (CcClientes cliente);

    CcClientes updateClient(Long id, CcClientes cliente);

    List<CcClientes> findByFilters(String names, String lastname, String telefono);
}
