package com.coder.facturacionreynosog.facturacion.controlador;

import com.coder.facturacionreynosog.facturacion.entidad.Cliente;
import com.coder.facturacionreynosog.facturacion.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/")
public class ClienteControlador {

    private final ClienteServicio clienteServicio;

    @Autowired
    public ClienteControlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }


    @GetMapping("/clientes/")
    public List<Cliente> getClientes() {
        return clienteServicio.getClientes();
    }

    @GetMapping("/clientes/{id}")
    public Optional<Cliente> getCliente(@PathVariable("id") Long id) {
        return clienteServicio.getCliente(id);
    }
    @PostMapping("/clientes/")
    public void addCliente(@RequestBody Cliente cliente) {
        clienteServicio.addCliente(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    public void removeCliente(@PathVariable("id") Long id) {
        clienteServicio.removeCliente(id);
    }

    @PutMapping("/clientes/{id}")
    public void updateCliente(@PathVariable("id") Long id,
                              @RequestParam(required = false) String nombre,
                              @RequestParam(required = false) String apellido) {
        clienteServicio.updateCliente(id, nombre, apellido);
    }
}