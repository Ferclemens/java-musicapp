package com.musicapp.musicapp.controller.Usuario;

import com.musicapp.musicapp.constantes.ConstantesUtils;
import com.musicapp.musicapp.dto.respuesta.RespuestaDto;
import com.musicapp.musicapp.dto.usuario.UsuarioDto;
import com.musicapp.musicapp.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/usuarios", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    @PostMapping
    public ResponseEntity<RespuestaDto> crearUsuarioConListas(@RequestBody UsuarioDto usuarioDto){
        usuarioService.crearUsuario(usuarioDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantesUtils.STATUS_201,ConstantesUtils.MESSAGE_201));
    }
}
