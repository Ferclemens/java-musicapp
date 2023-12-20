package com.musicapp.musicapp.mapper.genero;

import com.musicapp.musicapp.dto.genero.GeneroDto;
import com.musicapp.musicapp.entity.Genero;
import lombok.Data;

@Data
public class GeneroMapper {
    public static Genero mapToGenero(String generoDto, Genero genero){
        genero.setNombre(generoDto);
        return genero;
    }
    public static GeneroDto mapToGeneroDto(Genero genero, GeneroDto generoDto){
        generoDto.setNombre(genero.getNombre());
        return generoDto;
    }
}
