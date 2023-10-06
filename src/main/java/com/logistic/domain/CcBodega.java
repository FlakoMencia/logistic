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
@Table(name = "cc_bodega", schema = "public", catalog = "ingeneo")
public class CcBodega {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_bodega", nullable = false)
    private Long idBodega;
    @Basic
    @Column(name = "nombre", nullable = false, length = -1)
    private String nombre;
    @Basic
    @Column(name = "encargado", nullable = false, length = -1)
    private String encargado;
    @Basic
    @Column(name = "propietario", length = -1)
    private String propietario;
    @Basic
    @Column(name = "telefono", length = -1)
    private String telefono;
    @Basic
    @Column(name = "direccion", length = -1)
    private String direccion;
    @OneToMany(mappedBy = "ccBodegaByIdBodega")
    private Set<RegEnvio> regEnviosByIdBodega;
}
