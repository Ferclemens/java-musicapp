package com.musicapp.musicapp.dto.artista;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import com.musicapp.musicapp.entity.Cancion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArtistaDto {
    private String nombre;
    private List<CancionDto> cancionesDto = new ArrayList<>();

}
