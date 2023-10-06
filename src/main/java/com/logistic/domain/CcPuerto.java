package com.logistic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cc_puerto", schema = "public", catalog = "ingeneo")
public class CcPuerto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_puerto", nullable = false)
    private Long idPuerto;
    @Basic
    @Column(name = "codigo_puerto", nullable = false, length = -1)
    private String codigoPuerto;
    @Basic
    @Column(name = "nombre_puerto", nullable = false, length = -1)
    private String nombrePuerto;
    @Basic
    @Column(name = "direccion", length = -1)
    private String direccion;
    @Basic
    @Column(name = "telefono", length = -1)
    private String telefono;
    @OneToMany(mappedBy = "ccPuertoByIdPuerto")
    private Set<RegEnvio> regEnviosByIdPuerto;
}
