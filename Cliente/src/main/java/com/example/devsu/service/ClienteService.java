package com.example.devsu.service;

import com.example.devsu.dto.ClienteDTO;
import com.example.devsu.entity.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> getAllCLientes();
    public ClienteDTO getClienteById(Integer clienteId);
    public Cliente saveCliente(ClienteDTO cliente);
    public ClienteDTO updateCliente(ClienteDTO cliente);
    public void deleteCliente(Integer clienteId);
}
