package com.musicapp.musicapp.service.listaDeReproduccion.Impl;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.entity.Usuario;
import com.musicapp.musicapp.mapper.listaDeReproduccion.ListaDeReproduccionMapper;
import com.musicapp.musicapp.service.listaDeReproduccion.ListaDeReproduccionService;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class ListaDeReproduccionServiceImpl implements ListaDeReproduccionService {

    @Override
    public List<ListaDeReproduccion> crearListasDeReproduccion(List<ListaDeReproduccionDto> listaDeReproduccionDto, Usuario usuario) {
        ListaDeReproduccionMapper.mapToListasDeReproduccion(listaDeReproduccionDto, usuario.getListaDeReproduccion());
        //Continue here!
        return null;
    }
}
