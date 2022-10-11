package com.coder.facturacionreynosog.facturacion.servicio;

import com.coder.facturacionreynosog.facturacion.entidad.Cliente;
import com.coder.facturacionreynosog.facturacion.repositorio.ClienteRepositorio;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    private final ClienteRepositorio clienteRepositorio;

    public ClienteServicio(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public List<Cliente> getClientes() {
        return clienteRepositorio.findAll();
       }

    public void addCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    public Optional<Cliente> getCliente(Long id) {
        return clienteRepositorio.findById(id);
    }

    public void removeCliente(Long id) {
        boolean exists = clienteRepositorio.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El cliente " + id + " no existe.");
        }
            clienteRepositorio.deleteById(id);
        }

        @Transactional
    public void updateCliente(Long id, String nombre, String apellido) {
        Cliente cliente = clienteRepositorio.findById(id)
                .orElseThrow(() -> new IllegalStateException("El cliente " + id + " no existe"));
        if (nombre != null && nombre.length() > 0) {
            cliente.setNombre(nombre);
        }
    if (apellido!= null && apellido.length() > 0) {
        cliente.setApellido(apellido);

    }
        // no deberia ser necesario hacer SAVE por la anotacion Transactional clienteRepositorio.save(cliente);
        }

    }

