package com.coder.facturacionreynosog.facturacion.servicio;

import com.coder.facturacionreynosog.facturacion.entidad.Producto;
import com.coder.facturacionreynosog.facturacion.repositorio.ProductoRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    private final ProductoRepositorio productoRepositorio;

    ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }


    public List<Producto> getProductos() {
        return productoRepositorio.findAll();
    }

    public void addProducto(Producto producto) {
        productoRepositorio.save(producto);
    }

    public Optional<Producto> getProducto(Long id) {
        return productoRepositorio.findById(id);
    }

      public void updateProducto(int id, String descripcion, Double precio, Boolean esActivo) {
        //TODO: implementar cambio de precio, descripcion o si esta activo? o deberia pasarse esActivo al verbo
          // delete y borrar si no tiene uso o inactivar si tiene uso previo
          //un producto no se deberia poder cambiar el significado o descripcion para no cambiar registros existentes
      }


}
