package com.logistic.repository;

import com.logistic.domain.CcClientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CcClientesRepository extends JpaRepository<CcClientes, Long> {

//    List<CcClientes> findAllWithSpec(Specification<CcClientes> spec);

    @Query("SELECT o FROM CcClientes o WHERE "
            + "( :nombre IS NULL OR o.nombres LIKE %:nombre% ) AND"
            + "( :apellidos IS NULL OR o.apellidos LIKE %:apellidos% ) AND"
            + "( :telefono IS NULL OR o.telefono LIKE %:nombre% ) "
    )
    List<CcClientes>findByFilters(@Param("nombre") String nombre,
                                  @Param("apellidos")String apellidos,
                                  @Param("telefono")String tel);
}
