package com.logistic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cc_transporte", schema = "public", catalog = "ingeneo")
public class CcTransporte {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_transporte", nullable = false)
    private Long idTransporte;

    @Basic
    @Column(name = "tipo_transporte", nullable = false, length = -1)
    private String tipoTransporte;
    @Basic
    @Column(name = "apodo_referencia", length = -1)
    private String apodoReferencia;
    @Basic
    @Column(name = "placa", length = -1)
    @Size(max = 6, message = "El campo placa excede la longitud permitida")
    @Pattern(regexp="[a-zA-Z]{3}[0-9]{3}", message="Numero de Placa no permitda")
    private String placa;
    @Basic
    @Column(name = "matricula", length = -1)
    @Size(max = 8, message = "El campo flota excede la longitud permitida")
    @Pattern(regexp="[a-zA-Z]{3}[0-9]{4}[a-zA-Z]{1}", message="Numero de Matricula no permitda")
    private String matricula;
    @Basic
    @Column(name = "fabricante")
    private String fabricante;
    @Basic
    @Column(name = "anio")
    private Integer anio;
    @Basic
    @Column(name = "de_baja")
    private Boolean deBaja;

    @OneToMany(mappedBy = "ccTransporteByIdTransporte")
    private Set<RegEnvio> regEnviosByIdTransporte;
}
