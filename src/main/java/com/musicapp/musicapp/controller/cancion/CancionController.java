package com.musicapp.musicapp.controller.cancion;

import com.musicapp.musicapp.dto.cancion.CancionDto;
import com.musicapp.musicapp.service.cancion.CancionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping(value = "/api/v1/canciones", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CancionController {
    private final CancionService cancionService;
    @GetMapping()
    //Puntos 1 y 2 de Exploración y búsqueda
    public ResponseEntity<List<CancionDto>> obtenerTodasLasCanciones(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "genero", required = false) String genero,
            @RequestParam(name = "artista", required = false) String artista,
            @RequestParam(name = "album", required = false) String album
    ){
        List<CancionDto> canciones = cancionService.obtenerTodasLasCanciones(nombre, genero, artista, album);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(canciones);
    }

}
