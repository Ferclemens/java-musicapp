package com.musicapp.musicapp.service.cancion.Impl;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import com.musicapp.musicapp.entity.Artista;
import com.musicapp.musicapp.entity.Cancion;
import com.musicapp.musicapp.entity.Genero;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.mapper.cancion.CancionMapper;
import com.musicapp.musicapp.repository.cancion.CancionRepository;
import com.musicapp.musicapp.repository.listaDeReproduccion.ListaDeReproduccionRepository;
import com.musicapp.musicapp.service.artista.ArtistaService;
import com.musicapp.musicapp.service.cancion.CancionService;
import com.musicapp.musicapp.service.genero.GeneroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CancionServiceImpl implements CancionService {
    private final CancionRepository cancionRepository;
    private final ArtistaService artistaService;
    private final GeneroService generoService;
    private final ListaDeReproduccionRepository listaDeReproduccionRepository;

    @Override
    public List<Cancion> crearCanciones(List<CancionDto> cancionesDtos, List<Cancion> canciones){
        List<Cancion> cancionesAgregadas = CancionMapper.mapToCanciones(cancionesDtos, canciones);
        for (int i = 0; i < cancionesDtos.size(); i++) {
            Artista artista = new Artista();
            Genero genero = new Genero();
            canciones.get(i).setId(UUID.randomUUID());
            artistaService.crearArtista(cancionesDtos.get(i).getArtista(), artista);
            generoService.crearGenero(cancionesDtos.get(i).getGenero(), genero);
            canciones.get(i).setGenero(genero);
            canciones.get(i).setArtista(artista);
        }
        cancionRepository.saveAll(cancionesAgregadas);

        return cancionesAgregadas;
    }

    @Override
    public List<CancionDto> obtenerTodasLasCanciones(String nombre, String genero, String artista, String album) {

        if(!ObjectUtils.isEmpty(nombre)){
            return CancionMapper.mapToCancionesDto(cancionRepository.findByNombreStartingWith(nombre), new ArrayList<>());
        } else if (!ObjectUtils.isEmpty(album)) {
            return CancionMapper.mapToCancionesDto(cancionRepository.findByAlbumStartingWith(album), new ArrayList<>());
        } else if (!ObjectUtils.isEmpty(genero)){
//            return CancionMapper.mapToCancionesDto(cancionRepository.findByGeneroStartingWith(genero), new ArrayList<>());
            List<Cancion> listaCancionesMismoGenero = new ArrayList<>();
            for (Cancion cancionDB: cancionRepository.findAll()) {
                if(genero.equals(cancionDB.getGenero().getNombre())){
                    listaCancionesMismoGenero.add(cancionDB);
                }
            }
            return CancionMapper.mapToCancionesDto(listaCancionesMismoGenero, new ArrayList<>());
        } else if (!ObjectUtils.isEmpty(artista)) {
//            return CancionMapper.mapToCancionesDto(cancionRepository.findByArtistaStartingWith(artista), new ArrayList<>());
            List<Cancion> listaCancionesMismoArtistas = new ArrayList<>();
            for (Cancion cancionDB: cancionRepository.findAll()) {
                if(artista.equals(cancionDB.getArtista().getNombre())){
                    listaCancionesMismoArtistas.add(cancionDB);
                }
            }
            //Ordenamiento de los resultados del mismo artista de forma ascendente
            Collections.sort(listaCancionesMismoArtistas, (c1, c2) -> c1.getRanking() - c2.getRanking());
            return CancionMapper.mapToCancionesDto(listaCancionesMismoArtistas, new ArrayList<>());
        }
        return CancionMapper.mapToCancionesDto(cancionRepository.findAll(), new ArrayList<>());
    }

    @Override
    public List<CancionDto> obtenerCancionesDeListaDeReproduccion(UUID idListaDeReproduccion) {
        ListaDeReproduccion lista = listaDeReproduccionRepository.findById(idListaDeReproduccion)
                .orElseThrow(()-> new RuntimeException("No se encuentra lista de reproduccion con id " + idListaDeReproduccion));
        List<CancionDto> cancionesDto = CancionMapper.mapToCancionesDto(lista.getCanciones(), new ArrayList<>());
        return cancionesDto;
    }
}
