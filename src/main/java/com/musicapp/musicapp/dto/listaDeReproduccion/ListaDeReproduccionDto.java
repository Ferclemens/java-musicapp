package com.musicapp.musicapp.dto.listaDeReproduccion;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import com.musicapp.musicapp.entity.Cancion;
import com.musicapp.musicapp.entity.Usuario;
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
