package com.musicapp.musicapp.dto.listaDeReproduccion;


import lombok.Data;
import java.util.UUID;

@Data
public class ListaDeReproduccionDetalleDto {
    private UUID id;
    private String nombre;
    private int cantidadDeCanciones;
}
