package com.musicapp.musicapp.dto.usuario;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class UsuarioDto {
    private String nombre;
    private String usuario;
    private List<ListaDeReproduccionDto> listaDeReproduccionDto = new ArrayList<>();
}
