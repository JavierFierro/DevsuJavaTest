package com.example.devsu.client;

import com.example.devsu.dto.CuentaDTO;

import java.util.List;

public interface CuentaClient {
    public List<CuentaDTO> getCuentasByCliente(Integer clienteId);
}
