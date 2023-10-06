package com.logistic.repository;

import com.logistic.domain.CcPuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcPuertoRepository extends JpaRepository<CcPuerto, Long> {
}
