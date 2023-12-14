package com.musicapp.musicapp.service.usuario;

import com.musicapp.musicapp.dto.usuario.UsuarioDto;

public interface UsuarioService {
    default void crearUsuario(UsuarioDto usuarioDto) {

    }
}
