package com.musicapp.musicapp.dto.listaDeReproduccion;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class ListaDeReproduccionDto {
    @NotBlank(message = "El campo 'nombre' no puede estar vacio")
    private String nombre;
    @NotBlank(message = "El campo 'publica' no puede estar vacio")
    private boolean publica;
    @NotBlank(message = "El campo 'repetir' no puede estar vacio")
    private boolean repetir;
    @NotBlank(message = "El campo 'aleatorio' no puede estar vacio")
    private boolean aleatorio;
    @NotNull(message = "La lista de canciones no puede ser 'null'")
    private List<CancionDto> cancionesDto;
}
