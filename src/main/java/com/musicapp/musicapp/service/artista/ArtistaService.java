package com.musicapp.musicapp.service.artista;

import com.musicapp.musicapp.dto.artista.ArtistaDto;
import com.musicapp.musicapp.entity.Artista;

public interface ArtistaService {
    Artista crearArtista(ArtistaDto artistaDto, Artista artista);
}
