package com.musicapp.musicapp.service.artista;

import com.musicapp.musicapp.dto.artista.ArtistaDto;
import com.musicapp.musicapp.entity.Artista;

import java.util.List;
import java.util.UUID;

public interface ArtistaService {
    Artista crearArtista(String artistaDto, Artista artista);
    ArtistaDto obtenerArtistaPorId(UUID idArtista);

    List<ArtistaDto> obtenerTodosLosArtistas();
}
