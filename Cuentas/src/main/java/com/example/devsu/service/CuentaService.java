package com.example.devsu.service;

import com.example.devsu.dto.CuentaDTO;
import com.example.devsu.entity.Cuenta;

import java.util.List;

public interface CuentaService {

    public List<Cuenta> getAllCuentas();
    public CuentaDTO getCuentaById(String cuentaId);
    public List<Cuenta> getCuentasByClientId(Integer clientId);
    public Cuenta saveCuenta(CuentaDTO cuentaDTO);
    public CuentaDTO updateCuenta(CuentaDTO cuentaDTO);
    public void deleteCuenta(String cuentaId);
}
