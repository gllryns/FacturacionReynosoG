package com.coder.facturacionreynosog.facturacion.controlador;

import com.coder.facturacionreynosog.facturacion.entidad.Cliente;
import com.coder.facturacionreynosog.facturacion.entidad.Producto;
import com.coder.facturacionreynosog.facturacion.servicio.ClienteServicio;
import com.coder.facturacionreynosog.facturacion.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/")
public class ProductoControlador {
    private final ProductoServicio productoServicio;

    @Autowired
    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    @GetMapping("/productos/")
    public List<Producto> getProductos() {
        return productoServicio.getProductos();
    }
    @PostMapping("/productos/")
    public void addProducto(@RequestBody Producto producto) {
        productoServicio.addProducto(producto);
    }
    @PutMapping("/productos/{id}")
    public void updateProducto(@PathVariable("id") int id,
                               @RequestParam(required = false) Double precio,
                               @RequestParam(required = false) Boolean esActivo,
                               @RequestParam(required = false) String descripcion
    ){
        productoServicio.updateProducto(id, descripcion, precio, esActivo);
    }
}
