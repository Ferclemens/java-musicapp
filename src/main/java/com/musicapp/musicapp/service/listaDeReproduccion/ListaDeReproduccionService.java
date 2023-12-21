package com.musicapp.musicapp.service.listaDeReproduccion;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.entity.Usuario;

import java.util.List;

public interface ListaDeReproduccionService {
    void crearListasDeReproduccion(List<ListaDeReproduccionDto> listaDeReproduccionDto, Usuario usuario);
    boolean eliminarListas(List<ListaDeReproduccion> listas);

    List<ListaDeReproduccionDto> obtenerListasDeReproduccion(String nombre);
}
