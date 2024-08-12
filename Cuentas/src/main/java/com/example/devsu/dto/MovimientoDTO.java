package com.example.devsu.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoDTO implements Serializable {

    private String id;

    @NotEmpty
    private String fecha;

    @NotEmpty
    private String tipoMovimiento;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private BigDecimal saldo;

    @NotEmpty
    private String numeroCuenta;
}
