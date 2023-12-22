package com.musicapp.musicapp.controller.ListaDeReproduccion;

import com.musicapp.musicapp.constantes.ConstantesUtils;
import com.musicapp.musicapp.dto.cancion.CancionDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDetalleDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.dto.respuesta.RespuestaDto;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.service.cancion.CancionService;
import com.musicapp.musicapp.service.listaDeReproduccion.ListaDeReproduccionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/listasDeReproduccion", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ListaDeReproduccionController {
    ListaDeReproduccionService listaDeReproduccionService;
    CancionService cancionService;
    @GetMapping()
    public ResponseEntity<List<ListaDeReproduccionDto>> obtenerListasDeReproduccion(@RequestParam(name = "nombre", required = false)String nombre){
         List<ListaDeReproduccionDto> listas = listaDeReproduccionService.obtenerListasDeReproduccion(nombre);
         return ResponseEntity
                 .status(HttpStatus.OK)
                 .body(listas);
    }
    @GetMapping("/{idUsuario}/listas")
    public ResponseEntity<List<ListaDeReproduccionDetalleDto>> obtenerListasDeUnUsuario(@PathVariable(name = "idUsuario")UUID idUsuario){
        List<ListaDeReproduccionDetalleDto> listas = listaDeReproduccionService.obtenerListasDeUnUsuario(idUsuario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listas);
    }
    @GetMapping("/{idListaDeReproduccion}")
    public ResponseEntity<List<CancionDto>> obtenerCancionesDeListaDeReproduccion(@PathVariable(name = "idListaDeReproduccion") UUID idListaDeReproduccion){
        List<CancionDto> canciones = cancionService.obtenerCancionesDeListaDeReproduccion(idListaDeReproduccion);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(canciones);
    }
}
