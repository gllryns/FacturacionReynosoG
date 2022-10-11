package com.coder.facturacionreynosog.facturacion.repositorio;

import com.coder.facturacionreynosog.facturacion.entidad.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepositorio extends JpaRepository<Item, Long> {
 // List<Item> findByProductId(Long productId);
}