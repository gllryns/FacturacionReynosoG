package com.coder.facturacionreynosog.facturacion.entidad;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "productid", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "unidad", nullable = false, length = 30)
    private String unidad;

    @Column(name = "en_stock")
    private Integer enStock;

    @Column(name = "esActivo")
    private Boolean esActivo = Boolean.TRUE;

    public Producto(String nombre, String descripcion, String unidad, Integer enStock, Boolean esActivo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.enStock = enStock;
        this.esActivo = esActivo;
    }

    public Integer modificarStock(Integer modificacion) {
        if (modificacion == null) {
            modificacion = 0;
        }
        if ((this.enStock + modificacion) < 0) {
            //TODO: lanzar excepcion si stock queda negativo
            modificacion = 0;
        }
        this.enStock = enStock + modificacion;
        // si la modificacion es negativa pero el stock es positivo baja el stock
        return this.enStock;
    }

    public Boolean existeEnStock() {
        return this.enStock > 0;
    }
}