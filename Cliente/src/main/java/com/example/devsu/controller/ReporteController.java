package com.example.devsu.controller;

import com.example.devsu.dto.ReporteDTO;
import com.example.devsu.service.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/reporte")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping(value="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReporteDTO>> getClienteById(
            @PathVariable("id") Integer clienteId,
            @RequestParam String desde,
            @RequestParam String hasta
    ) {

        List<ReporteDTO> movimientos = reporteService.generarReportePorFecha(clienteId, desde, hasta);
        return new ResponseEntity<>(movimientos, HttpStatus.OK);
    }

}
