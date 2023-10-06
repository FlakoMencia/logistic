package com.logistic.repository;

import com.logistic.domain.CcTipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CcTipoProductoRepository extends JpaRepository<CcTipoProducto, Long> {

}
