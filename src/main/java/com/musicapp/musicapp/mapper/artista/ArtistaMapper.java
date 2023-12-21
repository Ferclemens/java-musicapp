package com.musicapp.musicapp.mapper.artista;

import com.musicapp.musicapp.dto.artista.ArtistaDto;
import com.musicapp.musicapp.entity.Artista;
import lombok.Data;

import java.util.List;

@Data
public class ArtistaMapper {
    public static Artista mapToArtista(String artistaDtoNombre, Artista artista){
        artista.setNombre(artistaDtoNombre);
        return artista;
    }
    public static ArtistaDto mapToArtistaDto(Artista artista, ArtistaDto artistaDto){
        artistaDto.setNombre(artista.getNombre());
        return artistaDto;
    }
    public static List<ArtistaDto> mapToArtistasDto(List<Artista> artistas,List<ArtistaDto> artistasDto){
        for (Artista artista: artistas) {
            artistasDto.add(
                    mapToArtistaDto(artista, new ArtistaDto())
            );
        }
        return (List<ArtistaDto>) artistasDto;
    }
    public static List<Artista> mapToArtistas(List<ArtistaDto> artistasDto,List<Artista> artistas){
        for (ArtistaDto artistaDto: artistasDto) {
            artistas.add(
                    mapToArtista(artistaDto.getNombre(), new Artista())
            );
        }
        return artistas;
    }
}
