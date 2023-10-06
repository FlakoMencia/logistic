package com.logistic.repository;

import com.logistic.domain.CcTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CcTransporteRepository extends JpaRepository<CcTransporte, Long> {

    List<CcTransporte> findCcTransporteByDeBaja(Boolean deBaja);

}
