package com.coder.facturacionreynosog.facturacion.entidad;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comprobantes")
public class Comprobante {
    public Comprobante(Long clienteId) {
        this.clienteId = clienteId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_seq")
    @SequenceGenerator(name = "comp_seq", sequenceName = "comp_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();


    @OneToMany(mappedBy = "comprobante", orphanRemoval = true)
    private List<Item> items = new ArrayList<>();

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, optional = false)
//    @JoinColumn(name = "cliente_id", nullable = false)
    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_comprobante")
    private EstadoComp estadoComprobante = EstadoComp.ABIERTO;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_comprobante")
    private TipoComp tipoComprobante = TipoComp.FACTURA;

    @Transient
    private Double total_pesos_comprobante = Double.valueOf(0);

    @Transient
    private Integer cantidad_productos_comprobante = Integer.valueOf(0);

    public Integer getCantidad_productos_comprobante() {
        return cantidad_productos_comprobante;
    }

    public void setCantidad_productos_comprobante(Integer cantidad_productos_comprobante) {
        this.cantidad_productos_comprobante = cantidad_productos_comprobante;
    }

    public Double getTotal_comprobante() {
        return total_pesos_comprobante;
    }

    public void setTotal_comprobante(Double total_comprobante) {
        this.total_pesos_comprobante = total_comprobante;
    }

    public enum TipoComp {
        FACTURA,
        CREDITO,
        REMITO
    }

    public enum EstadoComp {
        ABIERTO,
        CERRADO,
        EMITIDO
    }

}