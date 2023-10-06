package com.logistic.repository;

import com.logistic.domain.CcBodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcBodegaRepository extends JpaRepository<CcBodega, Long> {
}
