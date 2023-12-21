package com.musicapp.musicapp.service.listaDeReproduccion.Impl;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDetalleDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.entity.Cancion;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.entity.Usuario;
import com.musicapp.musicapp.mapper.cancion.CancionMapper;
import com.musicapp.musicapp.mapper.listaDeReproduccion.ListaDeReproduccionMapper;
import com.musicapp.musicapp.repository.cancion.CancionRepository;
import com.musicapp.musicapp.repository.listaDeReproduccion.ListaDeReproduccionRepository;
import com.musicapp.musicapp.repository.usuario.UsuarioRepository;
import com.musicapp.musicapp.service.cancion.CancionService;
import com.musicapp.musicapp.service.listaDeReproduccion.ListaDeReproduccionService;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.Index;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ListaDeReproduccionServiceImpl implements ListaDeReproduccionService {
    private final ListaDeReproduccionRepository listaDeReproduccionRepository;
    private final CancionService cancionService;
    private final UsuarioRepository usuarioRepository;
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

    @Override
    public boolean eliminarListas(List<ListaDeReproduccion> listas) {
        listaDeReproduccionRepository.deleteAll(listas);
        return Boolean.TRUE;
    }

    @Override
    public List<ListaDeReproduccionDto> obtenerListasDeReproduccion(String nombre) {
        List<ListaDeReproduccion> listas = listaDeReproduccionRepository.findAll();
        List<ListaDeReproduccionDto> listasDto = new ArrayList<>();
        if (!ObjectUtils.isEmpty(nombre)){
            for (ListaDeReproduccion lista : listas) {
                if (lista.getNombre().equals(nombre)) {
                    ListaDeReproduccionDto listaDto = ListaDeReproduccionMapper
                            .mapToListaDeReproduccionDto(lista, new ListaDeReproduccionDto());
                    listaDto.setCancionesDto(CancionMapper.mapToCancionesDto(lista.getCanciones(), new ArrayList<>()));
                    listasDto.add(listaDto);
                }
            }
        } else {
            for (ListaDeReproduccion lista : listas) {
                ListaDeReproduccionDto listaDto = ListaDeReproduccionMapper
                        .mapToListaDeReproduccionDto(lista, new ListaDeReproduccionDto());
                listaDto.setCancionesDto(CancionMapper.mapToCancionesDto(lista.getCanciones(), new ArrayList<>()));
                listasDto.add(listaDto);
            }
        }
        return listasDto;
    }

    @Override
    public List<ListaDeReproduccionDetalleDto> obtenerListasDeUnUsuario(UUID idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("No existe usuario con id: " + idUsuario));
        List<ListaDeReproduccion> listas = usuario.getListaDeReproduccion();
//        //Ordenamiento de los resultados por fecha (milisegundos)
//        Collections.sort(listas, (lista1, lista2) -> lista1.getCreadoEn().get(ChronoField.MILLI_OF_SECOND) - lista2.getCreadoEn().get(ChronoField.MILLI_OF_SECOND));
        List<ListaDeReproduccionDetalleDto> listasDelUsuarioDto = new ArrayList<>();
        for (ListaDeReproduccion lista: listas) {
            ListaDeReproduccionDetalleDto listaDetalleDto = ListaDeReproduccionMapper.mapToListaDeReproduccionDetalleDto(lista, new ListaDeReproduccionDetalleDto());
            listasDelUsuarioDto.add(listaDetalleDto);
        }
        return listasDelUsuarioDto;
    }
}

//        List<ListaDeReproduccion> listas = listaDeReproduccionRepository.findAll();
//        List<ListaDeReproduccion> listasParaMapper = new ArrayList<>();
//        if (!ObjectUtils.isEmpty(nombre)) {
//            for (ListaDeReproduccion lista : listas) {
//                if (lista.getNombre().equals(nombre)) {
//                    listasParaMapper.add(lista);
//                }
//            }
//        } else {
//            listasParaMapper = listas;
//        }
//        return ListaDeReproduccionMapper.mapToListasDeReproduccionDtos(listasParaMapper, new ArrayList<>());

//for (ListaDeReproduccion lista: listas) {
//        ListaDeReproduccionDto listaDto = ListaDeReproduccionMapper.mapToListaDeReproduccionDto(lista, new ListaDeReproduccionDto());
//        listaDto.setCancionesDto(CancionMapper.mapToCancionesDto(lista.getCanciones(), new ArrayList<>()));
//        listasDelUsuarioDto.add(listaDto);
//        }