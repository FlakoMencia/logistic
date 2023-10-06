package com.logistic.service;

import com.logistic.domain.CcTransporte;
import com.logistic.repository.CcTransporteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CcTransporteServiceImpl implements CcTransporteService{


    private final CcTransporteRepository ccTransporteRepository;

    public CcTransporteServiceImpl(CcTransporteRepository ccClientesRepository){
        this.ccTransporteRepository = ccClientesRepository;
    }

    @Override
    public List<CcTransporte> findAllAvailable() {
        return ccTransporteRepository.findCcTransporteByDeBaja(false);
    }

    @Override
    public CcTransporte registVehiculo(CcTransporte vehiculo) {
        return ccTransporteRepository.save(vehiculo);
    }

    @Override
    public CcTransporte darDeBaja(Long id) {
        CcTransporte vehiculo = ccTransporteRepository.findById(id).orElse(new CcTransporte());
        vehiculo.setDeBaja(true);
        return ccTransporteRepository.save(vehiculo);
    }
}
