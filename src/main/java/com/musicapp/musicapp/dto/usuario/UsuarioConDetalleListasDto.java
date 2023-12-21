package com.musicapp.musicapp.dto.usuario;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDetalleDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class UsuarioConDetalleListasDto {
    private String nombre;
    private String usuario;
    private List<ListaDeReproduccionDetalleDto> listaDeReproduccionDetalleDtos = new ArrayList<>();
}
