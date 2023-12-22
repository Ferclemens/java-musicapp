package com.musicapp.musicapp.controller.usuario;

import com.musicapp.musicapp.constantes.ConstantesUtils;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.dto.respuesta.RespuestaDto;
import com.musicapp.musicapp.dto.usuario.UsuarioConDetalleListasDto;
import com.musicapp.musicapp.dto.usuario.UsuarioDto;
import com.musicapp.musicapp.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/usuarios", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<RespuestaDto> crearUsuarioConListas(@RequestBody UsuarioDto usuarioDto){
        usuarioService.crearUsuarioConListas(usuarioDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantesUtils.STATUS_201,ConstantesUtils.MESSAGE_201));
    }
    @PostMapping("/{idUsuario}")
    public ResponseEntity<RespuestaDto> crearListaDeReproduccion(
            @RequestBody ListaDeReproduccionDto listaDeReproduccionDto,
            @PathVariable(name = "idUsuario") UUID idUsuario
    ){
        usuarioService.crearListaDeReproduccion(listaDeReproduccionDto, idUsuario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantesUtils.STATUS_201,ConstantesUtils.MESSAGE_201));
    }
    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioConDetalleListasDto> obtenerUsuarioPorId(@PathVariable(name = "idUsuario")UUID idUsuario){
        UsuarioConDetalleListasDto usuarioDto = usuarioService.obtenerUsuarioPorId(idUsuario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioDto);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<RespuestaDto> eliminarUsuarioPorId(@PathVariable(name = "idUsuario")UUID idUsuario){
        boolean usuarioEliminado = usuarioService.eliminarUsuarioPorId(idUsuario);
        if(usuarioEliminado){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new RespuestaDto(ConstantesUtils.STATUS_200, ConstantesUtils.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new RespuestaDto(ConstantesUtils.STATUS_500, ConstantesUtils.MESSAGE_500));
        }
    }
}
