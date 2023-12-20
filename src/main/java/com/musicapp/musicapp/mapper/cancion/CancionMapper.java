package com.musicapp.musicapp.mapper.cancion;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import com.musicapp.musicapp.entity.Cancion;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
public class CancionMapper {
    public static Cancion mapToCancion(CancionDto cancionDto, Cancion cancion){
        cancion.setNombre(cancionDto.getNombre());
        cancion.setRanking(cancionDto.getRanking());
        cancion.setDuracion(cancionDto.getDuracion());
        cancion.setAlbum(cancionDto.getAlbum());
        return cancion;
    }
    public static List<Cancion> mapToCanciones(Collection<CancionDto> cancionesDtos, Collection<Cancion> canciones){
        for (CancionDto cancionDto: cancionesDtos) {
            canciones.add(
                    mapToCancion(cancionDto, new Cancion())
            );
        }
        return (List<Cancion>) canciones;
    }
    public static CancionDto mapToCancionDto(Cancion cancion, CancionDto cancionDto){
        cancionDto.setNombre(cancion.getNombre());
        cancionDto.setRanking(cancion.getRanking());
        cancionDto.setGenero(cancion.getGenero().getNombre());
        cancionDto.setArtista(cancion.getArtista().getNombre());
        cancionDto.setDuracion(cancion.getDuracion());
        cancionDto.setAlbum(cancion.getAlbum());
        return cancionDto;
    }
    public static List<CancionDto> mapToCancionesDto(Collection<Cancion> canciones, Collection<CancionDto> cancionesDtos){
        for (Cancion cancion: canciones) {
            cancionesDtos.add(
                    mapToCancionDto(cancion, new CancionDto())
            );
        }
        return (List<CancionDto>) cancionesDtos;
    }
}
