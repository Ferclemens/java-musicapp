package com.musicapp.musicapp.service.listaDeReproduccion.Impl;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.entity.Cancion;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.entity.Usuario;
import com.musicapp.musicapp.mapper.cancion.CancionMapper;
import com.musicapp.musicapp.mapper.listaDeReproduccion.ListaDeReproduccionMapper;
import com.musicapp.musicapp.repository.cancion.CancionRepository;
import com.musicapp.musicapp.repository.listaDeReproduccion.ListaDeReproduccionRepository;
import com.musicapp.musicapp.service.cancion.CancionService;
import com.musicapp.musicapp.service.listaDeReproduccion.ListaDeReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ListaDeReproduccionServiceImpl implements ListaDeReproduccionService {
    private final ListaDeReproduccionRepository listaDeReproduccionRepository;
    private final CancionService cancionService;
    @Override
    public void crearListasDeReproduccion(List<ListaDeReproduccionDto> listaDeReproduccionDto, Usuario usuario) {
        ListaDeReproduccionMapper.mapToListasDeReproduccion(listaDeReproduccionDto, usuario.getListaDeReproduccion());
        for (int i = 0; i < listaDeReproduccionDto.size(); i++ ){
            List<Cancion> canciones = new ArrayList<>();
            usuario.getListaDeReproduccion().get(i).setId(UUID.randomUUID());
            usuario.getListaDeReproduccion().get(i).setCreadoPor("Admin");
            usuario.getListaDeReproduccion().get(i).setCreadoEn(LocalDateTime.now());
            usuario.getListaDeReproduccion().get(i).setUsuario(usuario);
            usuario.getListaDeReproduccion().get(i).setCanciones(canciones);
            cancionService.crearCanciones(listaDeReproduccionDto.get(i).getCancionesDto(),canciones);
        }
        listaDeReproduccionRepository.saveAll(usuario.getListaDeReproduccion());

    }
}
