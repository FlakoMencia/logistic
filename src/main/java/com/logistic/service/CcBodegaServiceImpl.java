package com.logistic.service;

import com.logistic.domain.CcBodega;
import com.logistic.repository.CcBodegaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CcBodegaServiceImpl implements CcBodegaService{

    private final CcBodegaRepository ccClientesRepository;

    public CcBodegaServiceImpl(CcBodegaRepository ccClientesRepository){
        this.ccClientesRepository = ccClientesRepository;
    }
    @Override
    public CcBodega registBodega(CcBodega bodega) {
        return ccClientesRepository.save(bodega);
    }

    @Override
    public List<CcBodega> findAllAvailable() {
        return ccClientesRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        ccClientesRepository.deleteById(id);
    }
}
