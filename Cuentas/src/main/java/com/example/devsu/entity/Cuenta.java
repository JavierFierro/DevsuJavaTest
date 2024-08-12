package com.example.devsu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cuenta")
public class Cuenta {

    @Id
    @UuidGenerator
    private String id;

    @Column(name = "numero_cuenta", unique = true, nullable = false)
    private String numeroCuenta;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "saldo_inicial")
    private BigDecimal saldoInicial;

    @Column(name = "estado")
    private boolean estado;

    @Column(name="cliente_id")
    private Integer clienteId;
}
