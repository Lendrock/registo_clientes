package org.flim.registro_cliente.service;

import org.flim.registro_cliente.entity.Cliente;
import org.flim.registro_cliente.repository.ClienteRepository;

//Inyectar dependecnia
import org.springframework.beans.factory.annotation.Autowire;
//componente de SpringBoot
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Override
    public List<Cliente> listarClientes() {
        return List.of();
    }

    @Override
    public Cliente buscarClienteporId(Integer codigo) {
        return null;
    }

    @Override
    public void guardarCliente(Cliente lciente) {

    }

    @Override
    public void eliminarCliente(Cliente cliente) {

    }
}
