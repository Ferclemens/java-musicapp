package com.musicapp.musicapp.service.usuario;

import com.musicapp.musicapp.dto.usuario.UsuarioConDetalleListasDto;
import com.musicapp.musicapp.dto.usuario.UsuarioDto;

import java.util.UUID;

public interface UsuarioService {
    void crearUsuarioConListas(UsuarioDto usuarioDto);
    UsuarioConDetalleListasDto obtenerUsuarioPorId(UUID idUsuario);

    boolean eliminarUsuarioPorId(UUID idUsuario);

}
