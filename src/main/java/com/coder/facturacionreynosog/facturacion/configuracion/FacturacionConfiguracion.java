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
            Producto producto1 = productoRepositorio.save(new Producto(15L,"Yerba", "Yerba mate Los Codeados", "Paquete", 20,
                    Boolean.TRUE));
            Producto producto2 = productoRepositorio.save(new Producto(16L,"Azucar", "Azucar de la house", "Paquete", 15, Boolean.TRUE));
            Producto producto3 = productoRepositorio.save(new Producto(17L,"Agua caliente", "Agua mineral a 85 grados para mate", "Termo",
                    20,
                    Boolean.TRUE));
            Cliente cliente1 = clienteRepositorio.save(new Cliente( "Alicia","Garcia"));

            Cliente cliente2 = clienteRepositorio.save(new Cliente( "Jose","Garcia"));
            Cliente cliente3 = clienteRepositorio.save(new Cliente( "Juan","Perez"));
            Cliente cliente4 = clienteRepositorio.save(new Cliente( "Agustín","Muiño"));

//            Comprobante comprobante1 = comprobanteRepositorio.save(new Comprobante(cliente1));
//            Comprobante comprobante2 = comprobanteRepositorio.save(new Comprobante(cliente1));
////
//            itemRepositorio.save(new Item(comprobante1,producto1, 350.0,2));
//            itemRepositorio.save(new Item(comprobante1,producto2, 200.0,3));
//            itemRepositorio.save(new Item(comprobante1,producto3, 100.0,1));
//            itemRepositorio.save(new Item(comprobante2,producto2, 250.0,4));
//            itemRepositorio.save(new Item(comprobante2,producto1, 400.0,5));
        };
    }
}
