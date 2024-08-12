package com.example.devsu.dto;

import com.example.devsu.entity.Persona;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO extends Persona implements Serializable {

    private Integer clienteId;

    @NotEmpty
    private String contrasena;
    private boolean estado;
}
