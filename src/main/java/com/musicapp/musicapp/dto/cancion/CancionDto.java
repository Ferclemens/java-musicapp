package com.musicapp.musicapp.dto.cancion;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.entity.Artista;
import com.musicapp.musicapp.entity.Genero;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import lombok.Data;

import java.util.List;
@Data
public class CancionDto {
    private String nombre;
    private int ranking;
    private Double duracion;
    private Genero genero;
    private Artista artista;
    private String album;
    private List<ListaDeReproduccion> listasDeReproduccion;
}
