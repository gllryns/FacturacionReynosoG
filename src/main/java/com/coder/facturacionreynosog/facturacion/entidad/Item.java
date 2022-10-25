package com.coder.facturacionreynosog.facturacion.entidad;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(name = "item_seq")
    @Column(name = "id", nullable = false)
    private Long id;

//    @ManyToOne(cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "comprobante_id", nullable = false)
@Column(name = "comprobante_id", nullable = false)
    private Long comprobante;

//    @ManyToOne(cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "producto_productid", nullable = false)
    @Column(name = "producto_id", nullable = false)
    private Long producto;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public double getSubTotal() {
        return this.cantidad * precio;
    }

    public Item(Long comprobante, Long producto, Double precio, Integer cantidad) {
        this.comprobante = comprobante;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}