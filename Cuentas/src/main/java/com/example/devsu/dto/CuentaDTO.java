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
public class CuentaDTO implements Serializable {

    private String id;

    @NotEmpty
    private String numeroCuenta;

    @NotEmpty
    private String tipo;

    @NotNull
    private BigDecimal saldoInicial;

    @NotNull
    private boolean estado;

    @NotNull
    private Integer clienteId;
}
