package com.example.devsu.controller;

import com.example.devsu.dto.MovimientoDTO;
import com.example.devsu.entity.Movimiento;
import com.example.devsu.exception.validation.InvalidBodyPropertiesException;
import com.example.devsu.service.MovimientoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movimientos")
@RequiredArgsConstructor
public class MovimientoController {

    private final MovimientoService movimientoService;

    @GetMapping()
    public ResponseEntity<List<Movimiento>> getAllMovimientos(){

        List<Movimiento> movimientoList = movimientoService.getAllMovimientos();
        return new ResponseEntity<>(movimientoList, HttpStatus.OK);
    }

    @GetMapping(value="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimientoDTO> getMovimientoById(@PathVariable("id") String movimientoId) {
        MovimientoDTO movimientoDTO = movimientoService.getMovimientoById(movimientoId);
        return new ResponseEntity<>(movimientoDTO, HttpStatus.OK);
    }

    @GetMapping(value="cuenta/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Movimiento>> getMovimientosByNumeroCuentaAndDateRange(
            @PathVariable("id") String numeroCuenta,
            @RequestParam String fechaDesde,
            @RequestParam String fechaHasta) {
        List<Movimiento> movimientosList = movimientoService.getMovimientosByNumeraCuentaAndDateRange(
                numeroCuenta, fechaDesde, fechaHasta);
        return new ResponseEntity<>(movimientosList, HttpStatus.OK);
    }

    @SneakyThrows
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movimiento> saveMovimiento(@Valid @RequestBody MovimientoDTO movimientoDTO, BindingResult result){
        if(result.hasErrors()) {
            throw new InvalidBodyPropertiesException("Error en las propiedades");
        }
        return new ResponseEntity<>(movimientoService.saveMovimiento(movimientoDTO), HttpStatus.OK);
    }

    @SneakyThrows
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimientoDTO> updateMovimiento(@Valid @RequestBody MovimientoDTO movimientoDTO, BindingResult result){
        if(result.hasErrors()) {
            throw new InvalidBodyPropertiesException("Error en las propiedades");
        }
        return new ResponseEntity<>(movimientoService.updateMovimiento(movimientoDTO), HttpStatus.OK);
    }

    @DeleteMapping(value="{id}")
    public void deleteMovimiento(@PathVariable("id") String movimentoId){
        movimientoService.deleteMovimiento(movimentoId);
    }

}
