package com.coder.facturacionreynosog.facturacion.servicio;

import com.coder.facturacionreynosog.facturacion.entidad.Comprobante;
import com.coder.facturacionreynosog.facturacion.repositorio.ComprobanteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComprobanteServicio {

    private final ComprobanteRepositorio comprobanteRepositorio;

    public ComprobanteServicio(ComprobanteRepositorio comprobanteRepositorio) {
        this.comprobanteRepositorio = comprobanteRepositorio;
    }
    public List<Comprobante> getComprobantes() {
    return comprobanteRepositorio.findAll();
    }

    public void addComprobante(Comprobante comprobante) {
    }
    /* la fecha se debe obtner del servicio http://worldclockapi.com/api/json/utc/now
    en caso de que el sericio falle calcular la fecha usando clase Date de Java
    Calcular el precio total de la venta
    Calcular la cantidad de productos que se venden
    Si alguna de las validaciones no se cumple se debe informar en la respuesta
     */
}
