package com.musicapp.musicapp.dto.cancion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CancionDto {
    @NotBlank(message = "El campo 'nombre' no puede estar vacio")
    private String nombre;
    private int ranking;
    @NotBlank(message = "El campo 'duracion' no puede estar vacio")
    @Positive(message = "El campo 'duracion' debe ser positivo")
    private Double duracion;
    @NotBlank(message = "El campo 'genero' no puede estar vacio")
    private String genero;
    @NotBlank(message = "El campo 'artista' no puede estar vacio")
    private String artista;
    private String album;
}
