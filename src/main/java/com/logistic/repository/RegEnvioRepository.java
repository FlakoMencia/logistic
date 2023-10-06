package com.logistic.repository;

import com.logistic.domain.RegEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegEnvioRepository extends JpaRepository<RegEnvio, Long> {


}

