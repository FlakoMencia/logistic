package com.logistic.service;

import com.logistic.domain.CcPuerto;
import com.logistic.repository.CcPuertoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CcPuertoServiceImpl implements CcPuertoService{


    private final CcPuertoRepository ccClientesRepository;

    public CcPuertoServiceImpl(CcPuertoRepository ccClientesRepository){
        this.ccClientesRepository = ccClientesRepository;
    }

    @Override
    public List<CcPuerto> findAllAvailable() {
        return ccClientesRepository.findAll();
    }

    @Override
    public CcPuerto registPuerto(CcPuerto puerto) {
        return ccClientesRepository.save(puerto);
    }

    @Override
    public void delete(Long id) {
        ccClientesRepository.deleteById(id);
    }
}
