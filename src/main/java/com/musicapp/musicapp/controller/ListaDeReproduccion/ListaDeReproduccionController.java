package com.musicapp.musicapp.controller.ListaDeReproduccion;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.service.listaDeReproduccion.ListaDeReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/listasDeReproduccion", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ListaDeReproduccionController {
    ListaDeReproduccionService listaDeReproduccionService;
    @GetMapping()
    public ResponseEntity<List<ListaDeReproduccionDto>> obtenerListasDeReproduccion(@RequestParam(name = "nombre", required = false)String nombre){
         List<ListaDeReproduccionDto> listas = listaDeReproduccionService.obtenerListasDeReproduccion(nombre);
         return ResponseEntity
                 .status(HttpStatus.OK)
                 .body(listas);
    }
}
