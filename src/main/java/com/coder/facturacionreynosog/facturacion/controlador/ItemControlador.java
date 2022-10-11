package com.coder.facturacionreynosog.facturacion.controlador;

import com.coder.facturacionreynosog.facturacion.entidad.Item;
import com.coder.facturacionreynosog.facturacion.servicio.ItemServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/v1/")
public class ItemControlador {
    private final ItemServicio itemServicio;

    @Autowired
    public ItemControlador(ItemServicio itemServicio) {
        this.itemServicio = itemServicio;
    }

    @GetMapping("/items/")
    public List<Item> getItems() {
        return itemServicio.getItems();
    }

    @GetMapping("/items/{id}")
    public Optional<Item> getItemById(@PathVariable("id") Long id) {
        return itemServicio.getItemById(id);
    }

    @PostMapping("/items/")
    public void AddItem(@RequestBody Item item) {
        itemServicio.addItem(item);
    }
 //   @GetMapping("/products/{id}/items/")
//    public List<Item> getProductItems(@PathVariable("id") Long id) {
//        return itemServicio.getItemsByProductId(id);
//
//    }

}
