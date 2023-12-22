package com.musicapp.musicapp.dto.listaDeReproduccion;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ListaDeReproduccionDetalleDto {
    private UUID id;
    private String nombre;
    private int cantidadDeCanciones;
}
