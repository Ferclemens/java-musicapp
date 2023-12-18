package com.musicapp.musicapp.service.artista.Impl;

import com.musicapp.musicapp.dto.artista.ArtistaDto;
import com.musicapp.musicapp.entity.Artista;
import com.musicapp.musicapp.mapper.artista.ArtistaMapper;
import com.musicapp.musicapp.repository.artista.ArtistaRepository;
import com.musicapp.musicapp.repository.genero.GeneroRepository;
import com.musicapp.musicapp.service.artista.ArtistaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class ArtistaServiceImpl implements ArtistaService {
    private final ArtistaRepository artistaRepository;
    @Override
    public Artista crearArtista(ArtistaDto artistaDto, Artista artista) {
        Artista artistaCreado = ArtistaMapper.mapToArtista(artistaDto, artista);
        artistaCreado.setId(UUID.randomUUID());
        artistaRepository.save(artistaCreado);
        return artistaCreado;
    }
}
