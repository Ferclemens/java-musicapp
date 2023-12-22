package com.musicapp.musicapp.dto.listaDeReproduccion;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import lombok.Data;

import java.util.List;
@Data
public class ListaDeReproduccionDto {
    private String nombre;
    private boolean Publica;
    private boolean Repetir;
    private boolean Aleatorio;
    private List<CancionDto> cancionesDto;
}
