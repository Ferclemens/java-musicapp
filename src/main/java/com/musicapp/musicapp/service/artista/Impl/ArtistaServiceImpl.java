package com.musicapp.musicapp.service.artista.Impl;

import com.musicapp.musicapp.dto.artista.ArtistaDto;
import com.musicapp.musicapp.entity.Artista;
import com.musicapp.musicapp.mapper.artista.ArtistaMapper;
import com.musicapp.musicapp.repository.artista.ArtistaRepository;
import com.musicapp.musicapp.repository.genero.GeneroRepository;
import com.musicapp.musicapp.service.artista.ArtistaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ArtistaServiceImpl implements ArtistaService {
    private final ArtistaRepository artistaRepository;
    @Override
    public Artista crearArtista(String artistaDto, Artista artista) {
        Artista artistaCreado = new Artista();
        List<Artista> listaDeArtistasDB = artistaRepository.findAll();
        if(listaDeArtistasDB.isEmpty()){
            artistaCreado = ArtistaMapper.mapToArtista(artistaDto, artista);
            artistaCreado.setId(UUID.randomUUID());
        } else {
            for (Artista artistaDB: listaDeArtistasDB) {
                if(artistaDB.getNombre() == artistaDto){
                    artistaCreado = artistaDB;
                } else {
                    artistaCreado = ArtistaMapper.mapToArtista(artistaDto, artista);
                    artistaCreado.setId(UUID.randomUUID());
                }
            }
        }
        artistaRepository.save(artistaCreado);
        return artistaCreado;
    }
}

//        Artista artistaCreado = new Artista();
//        List<Artista> listaDeArtistasDB = artistaRepository.findAll();
//        if(listaDeArtistasDB.isEmpty()){
//            artistaCreado = ArtistaMapper.mapToArtista(artistaDto, artista);
//            artistaCreado.setId(UUID.randomUUID());
//        } else {
//            for (Artista artistaDB: listaDeArtistasDB) {
//                if(artistaDB.getNombre() == artistaDto.getNombre()){
//                    artistaCreado = artistaDB;
//                } else {
//                    artistaCreado = ArtistaMapper.mapToArtista(artistaDto, artista);
//                    artistaCreado.setId(UUID.randomUUID());
//                }
//            }
//        }
//        artistaRepository.save(artistaCreado);
//        return artistaCreado;