package com.coder.facturacionreynosog.facturacion.repositorio;

import com.coder.facturacionreynosog.facturacion.entidad.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprobanteRepositorio extends JpaRepository<Comprobante, Long> {
}