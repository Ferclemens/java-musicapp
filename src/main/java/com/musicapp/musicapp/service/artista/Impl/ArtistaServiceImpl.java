package com.musicapp.musicapp.service.artista.Impl;

import com.musicapp.musicapp.dto.artista.ArtistaDto;
import com.musicapp.musicapp.entity.Artista;
import com.musicapp.musicapp.mapper.artista.ArtistaMapper;
import com.musicapp.musicapp.repository.artista.ArtistaRepository;
import com.musicapp.musicapp.repository.genero.GeneroRepository;
import com.musicapp.musicapp.service.artista.ArtistaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ArtistaServiceImpl implements ArtistaService {
    private final ArtistaRepository artistaRepository;
    @Override
    public Artista crearArtista(String artistaDto, Artista artista) {
        Artista artistaCreado = new Artista();
        artistaCreado = ArtistaMapper.mapToArtista(artistaDto, artista);
        artistaCreado.setId(UUID.randomUUID());
        artistaRepository.save(artistaCreado);
        return artistaCreado;
    }
//    Artista artistaCreado = new Artista();
//    Artista artistaExistente = artistaRepository.findByNombreStartingWith(artistaDto);
//        if (artistaExistente == null){
//        artistaCreado = ArtistaMapper.mapToArtista(artistaDto, artista);
//        artistaCreado.setId(UUID.randomUUID());
//    } else {
//        artistaCreado.setId(artistaExistente.getId());
//        artistaCreado.setNombre(artistaExistente.getNombre());
//    }
//        artistaRepository.save(artistaCreado);
//        return artistaCreado;
    @Override
    public ArtistaDto obtenerArtistaPorId(UUID idArtista) {
        Artista artista = artistaRepository.findById(idArtista)
                .orElseThrow(() -> new RuntimeException("No existe artista con id " + idArtista));
        ArtistaDto artistaDto = ArtistaMapper.mapToArtistaDto(artista, new ArtistaDto());
        return artistaDto;
    }

    @Override
    public List<ArtistaDto> obtenerTodosLosArtistas() {
        return ArtistaMapper.mapToArtistasDto(artistaRepository.findAll(), new ArrayList<>());
    }
}