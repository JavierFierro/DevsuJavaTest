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
@Table(name="movimiento")
public class Movimiento {

    @Id
    @UuidGenerator
    private String id;

    @Column(name="fecha")
    private String fecha;

    @Column(name="tipo_movimiento")
    private String tipoMovimiento;

    @Column(name="valor")
    private BigDecimal valor;

    @Column(name="saldo")
    private BigDecimal saldo;

    @Column(name="numero_cuenta")
    private String numeroCuenta;
}
