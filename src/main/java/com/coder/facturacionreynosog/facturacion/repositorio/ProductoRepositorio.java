package com.coder.facturacionreynosog.facturacion.repositorio;

import com.coder.facturacionreynosog.facturacion.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
}