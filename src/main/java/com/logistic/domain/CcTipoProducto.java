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
@Table(name = "cc_tipo_producto", schema = "public", catalog = "ingeneo")
public class CcTipoProducto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_tipo_prod", nullable = false)
    private Long idTipoProd;
    @Basic
    @Column(name = "codigo_producto", nullable = false, length = -1)
    private String codigoProducto;
    @Basic
    @Column(name = "nombre_producto", nullable = false, length = -1)
    private String nombreProducto;
    @Basic
    @Column(name = "especial", length = -1)
    private String especial;
    @Basic
    @Column(name = "unidad_medida", length = -1)
    private String unidadMedida;
    @OneToMany(mappedBy = "ccTipoProductoByIdProducto")
    private Set<RegEnvio> regEnviosByIdTipoProd;
}
