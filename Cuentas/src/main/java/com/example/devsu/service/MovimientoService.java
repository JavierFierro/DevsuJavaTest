package com.example.devsu.service;

import com.example.devsu.dto.MovimientoDTO;
import com.example.devsu.entity.Movimiento;

import java.util.List;

public interface MovimientoService {
    public List<Movimiento> getAllMovimientos();
    public MovimientoDTO getMovimientoById(String movimientoId);
    public List<Movimiento> getMovimientosByNumeraCuentaAndDateRange(String numeroCuenta, String fechaDesde, String fechaHasta);
    public Movimiento saveMovimiento(MovimientoDTO movimientoDTO);
    public MovimientoDTO updateMovimiento(MovimientoDTO movimientoDTO);
    public void deleteMovimiento(String movimientoId);
}
