package com.musicapp.musicapp.dto.artista;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArtistaDto {
    @NotBlank(message = "El campo 'nombre' no puede estar vacio")
    private String nombre;
}
