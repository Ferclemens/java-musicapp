package com.musicapp.musicapp.mapper.listaDeReproduccion;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.entity.Cancion;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
public class ListaDeReproduccionMapper {
    public static ListaDeReproduccion mapToListaDeReproduccion(ListaDeReproduccionDto listaDeReproduccionDto, ListaDeReproduccion listaDeReproduccion){
        listaDeReproduccion.setNombre(listaDeReproduccionDto.getNombre());
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
        return listaDeReproduccionDto;
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
