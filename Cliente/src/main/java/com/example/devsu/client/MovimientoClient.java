package com.example.devsu.client;

import com.example.devsu.dto.MovimientoDTO;

import java.util.List;

public interface MovimientoClient {
    public List<MovimientoDTO> getMovimientosByCuentaAndDateRange(String numeroCuenta, String fechaDesde, String fechaHasta);
}
