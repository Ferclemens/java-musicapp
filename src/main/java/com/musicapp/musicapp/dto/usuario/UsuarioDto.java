package com.musicapp.musicapp.dto.usuario;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class UsuarioDto {
    @NotBlank(message = "El campo 'nombre' no puede estar vacio")
    private String nombre;
    @NotBlank(message = "El campo 'usuario' no puede estar vacio")
    private String usuario;
    @NotNull(message = "La lista no puede ser 'null'")
    private List<ListaDeReproduccionDto> listaDeReproduccionDto = new ArrayList<>();
}
