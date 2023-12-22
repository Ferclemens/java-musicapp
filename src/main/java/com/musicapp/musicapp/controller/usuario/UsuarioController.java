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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@Validated
@RequestMapping(value = "/api/v1/usuarios", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UsuarioController {
    private final UsuarioService usuarioService;
    @PostMapping
    // punto 1 de perfil de usuario
    public ResponseEntity<RespuestaDto> crearUsuarioConListas(@RequestBody UsuarioDto usuarioDto){
        usuarioService.crearUsuarioConListas(usuarioDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantesUtils.STATUS_201,ConstantesUtils.MESSAGE_201));
    }
    @PostMapping("/{idUsuario}")
    // punto 3 de listas de reproduccion
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
    // punto 2 de perfil de usuario
    public ResponseEntity<UsuarioConDetalleListasDto> obtenerUsuarioPorId(@PathVariable(name = "idUsuario")UUID idUsuario){
        UsuarioConDetalleListasDto usuarioDto = usuarioService.obtenerUsuarioPorId(idUsuario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioDto);
    }
}
