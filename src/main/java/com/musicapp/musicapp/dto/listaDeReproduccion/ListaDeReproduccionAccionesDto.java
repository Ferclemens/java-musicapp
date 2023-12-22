package com.musicapp.musicapp.dto.listaDeReproduccion;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ListaDeReproduccionAccionesDto {
    @NotNull(message = "El campo 'publica' no puede ser nulo")
    private boolean publica;
    @NotNull(message = "El campo 'repetir' no puede ser nulo")
    private boolean repetir;
    @NotNull(message = "El campo 'Aleatorio' no puede ser nulo")
    private boolean aleatorio;
}
