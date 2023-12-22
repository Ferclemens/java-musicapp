package com.musicapp.musicapp.dto.cancion;

import com.musicapp.musicapp.dto.artista.ArtistaDto;
import com.musicapp.musicapp.dto.genero.GeneroDto;
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
    private String genero;
    private String artista;
    private String album;
}
