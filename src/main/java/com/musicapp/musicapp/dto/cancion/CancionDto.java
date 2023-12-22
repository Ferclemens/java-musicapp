package com.musicapp.musicapp.dto.cancion;

import lombok.Data;

@Data
public class CancionDto {
    private String nombre;
    private int ranking;
    private Double duracion;
    private String genero;
    private String artista;
    private String album;
}
