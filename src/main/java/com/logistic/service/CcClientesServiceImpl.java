package com.logistic.service;

import com.logistic.domain.CcClientes;
import com.logistic.repository.CcClientesRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CcClientesServiceImpl implements CcClientesService{

    private final CcClientesRepository ccClientesRepository;

    public CcClientesServiceImpl(CcClientesRepository ccClientesRepository){
        this.ccClientesRepository = ccClientesRepository;
    }

    @Override
    @Transactional
    public CcClientes registClient(CcClientes cliente) {
        return ccClientesRepository.save(cliente);
    }

    @Override
    @Transactional
    public CcClientes updateClient(Long id, CcClientes cliente) {
        if (cliente.getIdCliente() == null) {
            throw new RuntimeException("Can not update entity, entity without ID.");
        } else if (!id.equals(cliente.getIdCliente())) {
            throw new RuntimeException(String.format("Can not update entity, the resource ID not Found"
                    , id, cliente.getIdCliente()));
        }
        return ccClientesRepository.save(cliente);
    }

    @Override
    public List<CcClientes> findByFilters(String names, String lastname, String telefono) {

        return ccClientesRepository.findByFilters(names, lastname, telefono);
    }
}