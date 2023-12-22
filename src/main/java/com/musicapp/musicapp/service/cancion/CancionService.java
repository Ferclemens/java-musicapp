package com.musicapp.musicapp.service.cancion;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import com.musicapp.musicapp.entity.Cancion;

import java.util.List;
import java.util.UUID;

public interface CancionService {
    List<Cancion> crearCanciones(List<CancionDto> cancionesDtos, List<Cancion> canciones);
    List<CancionDto> obtenerTodasLasCanciones(String nombre, String genero, String artista, String album);

    List<CancionDto> obtenerCancionesDeListaDeReproduccion(UUID idListaDeReproduccion);
}
