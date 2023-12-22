package com.musicapp.musicapp.dto.genero;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GeneroDto {
    @NotBlank(message = "El campo 'nombre' no puede estar vacio")
    private String nombre;
}
