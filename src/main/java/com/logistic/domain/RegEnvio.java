package com.logistic.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "log_envio", schema = "public", catalog = "ingeneo")
public class RegEnvio {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_envio", nullable = false)
    private Long idEnvio;
    @Basic
    @Column(name = "numero_orden", nullable = false)
    private Integer numeroOrden;
    @Basic
    @Column(name = "fecha_registro", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fechaRegistro;
    @Basic
    @Column(name = "fecha_entrega")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fechaEntrega;
    @Basic
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic
    @Column(name = "precio_envio", length = -1)
    private String precioEnvio;
    @Basic
    @Column(name = "tipo_descuento", length = -1)
    private String tipoDescuento;
    @Basic
    @Column(name = "descuento", length = -1)
    private String descuento;
    @Basic
    @Column(name = "precio_total", length = -1)
    private String precioTotal;
    @ManyToOne
    @JoinColumn(name = "id_transporte", referencedColumnName = "id_transporte", nullable = false)
    private CcTransporte ccTransporteByIdTransporte;
    @ManyToOne
    @JoinColumn(name = "id_bodega", referencedColumnName = "id_bodega")
    private CcBodega ccBodegaByIdBodega;
    @ManyToOne
    @JoinColumn(name = "id_puerto", referencedColumnName = "id_puerto")
    private CcPuerto ccPuertoByIdPuerto;
    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_tipo_prod", nullable = false)
    private CcTipoProducto ccTipoProductoByIdProducto;

}
