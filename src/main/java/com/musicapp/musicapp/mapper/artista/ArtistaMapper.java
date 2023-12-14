package com.musicapp.musicapp.mapper.artista;

import com.musicapp.musicapp.dto.artista.ArtistaDto;
import com.musicapp.musicapp.entity.Artista;
import lombok.Data;

@Data
public class ArtistaMapper {
    public static Artista mapToArtista(ArtistaDto artistaDto, Artista artista){
        artista.setNombre(artistaDto.getNombre());
        return artista;
    }
    public static ArtistaDto mapToArtistaDto(Artista artista, ArtistaDto artistaDto){
        artistaDto.setNombre(artista.getNombre());
        return artistaDto;
    }
}
