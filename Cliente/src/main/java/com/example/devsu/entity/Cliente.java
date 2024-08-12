package com.example.devsu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cliente")
public class Cliente extends Persona{

    @Id
    @Column(name = "cliente_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clienteId;

    @Column(name="contrasena")
    private String contrasena;

    @Column(name="estado")
    private boolean estado;
}
