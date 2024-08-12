package com.example.devsu.service;

import com.example.devsu.dto.ReporteDTO;

import java.util.List;

public interface ReporteService {
    public List<ReporteDTO> generarReportePorFecha(Integer clienteId, String fechaDesde, String fechaHasta);
}
