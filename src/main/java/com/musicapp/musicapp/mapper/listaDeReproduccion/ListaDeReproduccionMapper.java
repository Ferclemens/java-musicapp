package com.musicapp.musicapp.mapper.listaDeReproduccion;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionAccionesDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDetalleDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
public class ListaDeReproduccionMapper {
    public static ListaDeReproduccion mapToListaDeReproduccion(ListaDeReproduccionDto listaDeReproduccionDto, ListaDeReproduccion listaDeReproduccion){
        listaDeReproduccion.setNombre(listaDeReproduccionDto.getNombre());
        listaDeReproduccion.setAleatorio(listaDeReproduccionDto.isAleatorio());
        listaDeReproduccion.setRepetir(listaDeReproduccionDto.isRepetir());
        listaDeReproduccion.setPublica(listaDeReproduccion.isPublica());
        return listaDeReproduccion;
    }
    public static ListaDeReproduccion mapToListaDeReproduccionAcciones(ListaDeReproduccionAccionesDto listaDeReproduccionAccionesDto, ListaDeReproduccion listaDeReproduccion){
        listaDeReproduccion.setAleatorio(listaDeReproduccionAccionesDto.isAleatorio());
        listaDeReproduccion.setRepetir(listaDeReproduccionAccionesDto.isRepetir());
        listaDeReproduccion.setPublica(listaDeReproduccionAccionesDto.isPublica());
        return listaDeReproduccion;
    }
    public static List<ListaDeReproduccion> mapToListasDeReproduccion(Collection<ListaDeReproduccionDto> listasDeReproduccionDtos, Collection<ListaDeReproduccion> listasDeReproduccion){
        for (ListaDeReproduccionDto listaDto: listasDeReproduccionDtos) {
            listasDeReproduccion.add(
                mapToListaDeReproduccion(listaDto, new ListaDeReproduccion())
            );
        }
        return (List<ListaDeReproduccion>) listasDeReproduccion;
    }
    public static ListaDeReproduccionDto mapToListaDeReproduccionDto(ListaDeReproduccion listaDeReproduccion, ListaDeReproduccionDto listaDeReproduccionDto){
        listaDeReproduccionDto.setNombre(listaDeReproduccion.getNombre());
        listaDeReproduccionDto.setAleatorio(listaDeReproduccion.isAleatorio());
        listaDeReproduccionDto.setRepetir(listaDeReproduccion.isRepetir());
        listaDeReproduccionDto.setPublica(listaDeReproduccion.isPublica());
        return listaDeReproduccionDto;
    }
    public static ListaDeReproduccionDetalleDto mapToListaDeReproduccionDetalleDto(ListaDeReproduccion listaDeReproduccion, ListaDeReproduccionDetalleDto listaDeReproduccionDetalleDto){
        listaDeReproduccionDetalleDto.setId(listaDeReproduccion.getId());
        listaDeReproduccionDetalleDto.setNombre(listaDeReproduccion.getNombre());
        listaDeReproduccionDetalleDto.setCantidadDeCanciones(listaDeReproduccion.getCanciones().size());
        return listaDeReproduccionDetalleDto;
    }
    public static List<ListaDeReproduccionDto> mapToListasDeReproduccionDtos(Collection<ListaDeReproduccion> listasDeReproduccion, Collection<ListaDeReproduccionDto> listasDeReproduccionDtos){
        for (ListaDeReproduccion lista: listasDeReproduccion) {
            listasDeReproduccionDtos.add(
                    mapToListaDeReproduccionDto(lista, new ListaDeReproduccionDto())
            );
        }
        return (List<ListaDeReproduccionDto>) listasDeReproduccionDtos;
    }

}
