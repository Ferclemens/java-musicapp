package com.musicapp.musicapp.service.usuario.Impl;

import com.musicapp.musicapp.dto.usuario.UsuarioDto;
import com.musicapp.musicapp.entity.Usuario;
import com.musicapp.musicapp.mapper.usuario.UsuarioMapper;
import com.musicapp.musicapp.repository.usuario.UsuarioRepository;
import com.musicapp.musicapp.service.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Override
    public void crearUsuario(UsuarioDto usuarioDto) {
        Usuario nuevoUsuario = UsuarioMapper.mapToUsuario(usuarioDto, new Usuario());
        nuevoUsuario.setId(UUID.randomUUID());
        nuevoUsuario.setCreadoPor("Admin");
        nuevoUsuario.setCreadoEn(LocalDateTime.now());

        usuarioRepository.save(nuevoUsuario);
    }
}
