package com.coder.facturacionreynosog.facturacion.configuracion;

import com.coder.facturacionreynosog.facturacion.entidad.Cliente;
import com.coder.facturacionreynosog.facturacion.entidad.Comprobante;
import com.coder.facturacionreynosog.facturacion.entidad.Item;
import com.coder.facturacionreynosog.facturacion.entidad.Producto;
import com.coder.facturacionreynosog.facturacion.repositorio.ClienteRepositorio;
import com.coder.facturacionreynosog.facturacion.repositorio.ComprobanteRepositorio;
import com.coder.facturacionreynosog.facturacion.repositorio.ItemRepositorio;
import com.coder.facturacionreynosog.facturacion.repositorio.ProductoRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacturacionConfiguracion {
    @Bean
    CommandLineRunner commandLineRunner(ClienteRepositorio clienteRepositorio,
                                        ProductoRepositorio productoRepositorio,
                                        ComprobanteRepositorio comprobanteRepositorio,
                                        ItemRepositorio itemRepositorio) {
        return args -> {
            productoRepositorio.save(new Producto("Yerba", "Yerba mate Los Codeados", "Paquete", 20,
                    Boolean.TRUE));
            productoRepositorio.save(new Producto("Azucar", "Azucar de la house", "Paquete", 15, Boolean.TRUE));
            productoRepositorio.save(new Producto("Agua caliente", "Agua mineral a 85 grados para mate", "Termo",
                    20,
                    Boolean.TRUE));

            clienteRepositorio.save(new Cliente( "Alicia","Garcia"));
            clienteRepositorio.save(new Cliente( "Jose","Garcia"));
            clienteRepositorio.save(new Cliente( "Juan","Perez"));
            clienteRepositorio.save(new Cliente( "Agustín","Muiño"));

            comprobanteRepositorio.save(new Comprobante(1L));
            comprobanteRepositorio.save(new Comprobante(1L));
            comprobanteRepositorio.save(new Comprobante(2L));

            itemRepositorio.save(new Item(1L,1L, 350.0,2));
            itemRepositorio.save(new Item(1L,2L, 200.0,3));
            itemRepositorio.save(new Item(1L,3L, 100.0,1));
            itemRepositorio.save(new Item(2L,2L, 250.0,4));
            itemRepositorio.save(new Item(2L,1L, 400.0,5));
        };
    }
}
