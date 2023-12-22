package com.musicapp.musicapp.controller.ListaDeReproduccion;

import com.musicapp.musicapp.constantes.ConstantesUtils;
import com.musicapp.musicapp.dto.cancion.CancionDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionAccionesDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDetalleDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.dto.respuesta.RespuestaDto;
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
    @PutMapping("/{idListaDeReproduccion}")
    public ResponseEntity<RespuestaDto> editarParametrosDeAcciones(
            @PathVariable(name = "idListaDeReproduccion")UUID idListaDeReproduccion,
            @RequestBody ListaDeReproduccionAccionesDto listaDeReproduccionAccionesDto
            ){
        boolean fueEditado = listaDeReproduccionService.editarParametrosDeAcciones(
                idListaDeReproduccion,
                listaDeReproduccionAccionesDto
        );
        if (fueEditado){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new RespuestaDto(ConstantesUtils.STATUS_200,ConstantesUtils.MESSAGE_200));
        } else {
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(new RespuestaDto(ConstantesUtils.STATUS_500,ConstantesUtils.MESSAGE_500));
        }

    }
    @PutMapping("/{idListaDeReproduccion}/agregar-cancion/{idCancion}")
    public ResponseEntity<RespuestaDto> editarCancionEnListaDeReproduccion(
            @PathVariable(name = "idListaDeReproduccion") UUID idListaDeReproduccion,
            @PathVariable(name = "idCancion") UUID idCancion
    ){
        boolean fueEditado = listaDeReproduccionService.editarCancionEnListaDeReproduccion(
                idListaDeReproduccion,
                idCancion
        );
        if (fueEditado){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new RespuestaDto(ConstantesUtils.STATUS_200,ConstantesUtils.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new RespuestaDto(ConstantesUtils.STATUS_500,ConstantesUtils.MESSAGE_500));
        }

    }
}
