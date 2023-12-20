package com.musicapp.musicapp.mapper.artista;

import com.musicapp.musicapp.dto.artista.ArtistaDto;
import com.musicapp.musicapp.entity.Artista;
import lombok.Data;

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
}
