package com.coder.facturacionreynosog.facturacion.controlador;

import com.coder.facturacionreynosog.facturacion.entidad.Comprobante;
import com.coder.facturacionreynosog.facturacion.entidad.Producto;
import com.coder.facturacionreynosog.facturacion.servicio.ComprobanteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/")
public class ComprobanteControlador {
    private final ComprobanteServicio comprobanteServicio;

    @GetMapping("/comprobantes/")
    public List<Comprobante> getComprobante() {
        return comprobanteServicio.getComprobantes();
    }

    @Autowired
    public ComprobanteControlador(ComprobanteServicio comprobanteServicio) {
        this.comprobanteServicio = comprobanteServicio;
    }

    @PostMapping("/comprobantes/")
    public void addComprobante(@RequestBody Comprobante comprobante) {
        comprobanteServicio.addComprobante(comprobante);
    }


}


