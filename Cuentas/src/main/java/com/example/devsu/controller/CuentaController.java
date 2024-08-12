package com.example.devsu.controller;

import com.example.devsu.dto.CuentaDTO;
import com.example.devsu.entity.Cuenta;
import com.example.devsu.exception.validation.InvalidBodyPropertiesException;
import com.example.devsu.service.CuentaService;
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
@RequestMapping("api/cuentas")
@RequiredArgsConstructor
public class CuentaController {

    private final CuentaService cuentaService;

    @GetMapping()
    public ResponseEntity<List<Cuenta>> getAllCuentas(){

        List<Cuenta> cuentaList = cuentaService.getAllCuentas();
        return new ResponseEntity<>(cuentaList, HttpStatus.OK);
    }

    @GetMapping(value="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CuentaDTO> getCuentaById(@PathVariable("id") String cuentaId) {

        CuentaDTO cuentaoDTO = cuentaService.getCuentaById(cuentaId);
        return new ResponseEntity<>(cuentaoDTO, HttpStatus.OK);

    }

    @GetMapping(value="client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cuenta>> getCuentaByClientId(@PathVariable("id") Integer clientId) {

        List<Cuenta> cuentaList = cuentaService.getCuentasByClientId(clientId);
        return new ResponseEntity<>(cuentaList, HttpStatus.OK);

    }

    @SneakyThrows
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cuenta> saveCuenta(@Valid @RequestBody CuentaDTO cuentaDTO, BindingResult result){
        if(result.hasErrors()) {
            throw new InvalidBodyPropertiesException("Error en las propiedades");
        }
        return new ResponseEntity<>(cuentaService.saveCuenta(cuentaDTO), HttpStatus.OK);
    }

    @SneakyThrows
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CuentaDTO> updateCuenta(@Valid @RequestBody CuentaDTO cuentaDTO, BindingResult result){
        if(result.hasErrors()) {
            throw new InvalidBodyPropertiesException("Error en las propiedades");
        }
        return new ResponseEntity<>(cuentaService.updateCuenta(cuentaDTO), HttpStatus.OK);
    }

    @DeleteMapping(value="{id}")
    public void deleteCuenta(@PathVariable("id") String cuentaId){
        cuentaService.deleteCuenta(cuentaId);
    }

}
