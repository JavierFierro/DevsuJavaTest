package com.example.devsu.repository;

import com.example.devsu.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta, String> {
    public List<Cuenta> getAllByClienteId(Integer clienteId);
    public Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);
}
