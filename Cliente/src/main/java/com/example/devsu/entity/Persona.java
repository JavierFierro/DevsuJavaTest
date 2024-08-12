package com.example.devsu.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@MappedSuperclass
public class Persona {

    @NotEmpty
    private String identificacion;

    @NotEmpty
    private String nombre;
    private String genero;
    private String edad;
    private String direccion;
    private String telefono;
}
