package com.musicapp.musicapp.controller.Usuario;

import com.musicapp.musicapp.dto.respuesta.RespuestaDto;
import com.musicapp.musicapp.dto.usuario.UsuarioDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/usuarios", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UsuarioController {
    @PostMapping
    public ResponseEntity<RespuestaDto> crearUsuario(@RequestBody UsuarioDto usuarioDto){
        return null;
    }
}
