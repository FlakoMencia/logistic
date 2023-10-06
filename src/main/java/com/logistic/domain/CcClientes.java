package com.logistic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "cc_clientes", schema = "public", catalog = "ingeneo")
public class CcClientes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;
    @Basic
    @Column(name = "nombres", nullable = false, length = -1)
    private String nombres;
    @Basic
    @Column(name = "apellidos", nullable = false, length = -1)
    private String apellidos;
    @Basic
    @Column(name = "genero", length = -1)
    private String genero;
    @Basic
    @Column(name = "correo", length = -1)
    private String correo;
    @Basic
    @Column(name = "telefono", length = -1)
    private String telefono;
    @Basic
    @Column(name = "direccion", length = -1)
    private String direccion;
    @Basic
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    @Basic
    @Column(name = "comentarios", length = -1)
    private String comentarios;
}
