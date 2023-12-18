package com.musicapp.musicapp.service.cancion.Impl;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import com.musicapp.musicapp.entity.Artista;
import com.musicapp.musicapp.entity.Cancion;
import com.musicapp.musicapp.entity.Genero;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.mapper.cancion.CancionMapper;
import com.musicapp.musicapp.mapper.listaDeReproduccion.ListaDeReproduccionMapper;
import com.musicapp.musicapp.repository.cancion.CancionRepository;
import com.musicapp.musicapp.service.artista.ArtistaService;
import com.musicapp.musicapp.service.cancion.CancionService;
import com.musicapp.musicapp.service.genero.GeneroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CancionServiceImpl implements CancionService {
    private final CancionRepository cancionRepository;
    private final ArtistaService artistaService;
    private final GeneroService generoService;
    @Override
    public List<Cancion> crearCanciones(List<CancionDto> cancionesDtos, List<Cancion> canciones){
        List<Cancion> cancionesAgregadas = CancionMapper.mapToCanciones(cancionesDtos, canciones);
        for (int i = 0; i < cancionesDtos.size(); i++) {
            Artista artista = new Artista();
            Genero genero = new Genero();
            canciones.get(i).setId(UUID.randomUUID());
            artistaService.crearArtista(cancionesDtos.get(i).getArtistaDto(), artista);
            generoService.crearGenero(cancionesDtos.get(i).getGeneroDto(), genero);
            canciones.get(i).setGenero(genero);
            canciones.get(i).setArtista(artista);
        }
        cancionRepository.saveAll(cancionesAgregadas);

        return cancionesAgregadas;
    }
}
