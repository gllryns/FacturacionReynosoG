package com.coder.facturacionreynosog.facturacion.servicio;

import com.coder.facturacionreynosog.facturacion.entidad.Item;
import com.coder.facturacionreynosog.facturacion.repositorio.ItemRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServicio {
    private final ItemRepositorio itemRepositorio;


    public ItemServicio(ItemRepositorio itemRepositorio) {
        this.itemRepositorio = itemRepositorio;
    }

    public List<Item> getItems() {
        return itemRepositorio.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepositorio.findById(id);
    }

//    public List<Item> getItemsByProductId(Long productId) {
//        return itemRepositorio.findByProductId(productId);
//    }

    public void addItem(Item item) {
        itemRepositorio.save(item);
    }
    public void removeItem(Long id) {
        //TODO: implementar que el item solo se pueda remover si el comprobante esta abierto
//        boolean exists = itemRepositorio.existsById(id);
//        if (!exists) {
//            throw new IllegalStateException("El item " + id + " no existe.");
//        }
//        itemRepositorio.deleteById(id);
    }
     //TODO: implementar que el item solo puede modificar la cantidad, y que el precio del item es el precio del
    // producto al crear el item (o al cerrar la factura???)

}
