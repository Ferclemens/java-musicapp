package com.musicapp.musicapp.dto.listaDeReproduccion;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.UUID;

@Data
public class ListaDeReproduccionDetalleDto {
    @NotNull(message = "El campo 'id' no puede ser 'null'")
    private UUID id;
    @NotBlank(message = "El campo 'nombre' no puede estar vacio")
    private String nombre;
    @NotBlank(message = "El campo 'cantidadDeCanciones' no puede estar vacio")
    @Min(value = 0, message = "La cantidad de canciones debe ser como mínimo 0")
    private int cantidadDeCanciones;
}
