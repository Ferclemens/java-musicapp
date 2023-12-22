package com.musicapp.musicapp.service.listaDeReproduccion;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionAccionesDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDetalleDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.entity.Usuario;

import java.util.List;
import java.util.UUID;

public interface ListaDeReproduccionService {
    void crearListasDeReproduccion(List<ListaDeReproduccionDto> listaDeReproduccionDto, Usuario usuario);
    boolean eliminarListas(List<ListaDeReproduccion> listas);

    List<ListaDeReproduccionDto> obtenerListasDeReproduccion(String nombre);

    List<ListaDeReproduccionDetalleDto> obtenerListasDeUnUsuario(UUID idUsuario);

    boolean editarParametrosDeAcciones(UUID idListaDeReproduccion, ListaDeReproduccionAccionesDto listaDeReproduccionAccionesDto);

    boolean editarCancionEnListaDeReproduccion(UUID idListaDeReproduccion, UUID idCancion);

    boolean eliminarCancionEnListaDeReproduccion(UUID idListaDeReproduccion, UUID idCancion);
}
