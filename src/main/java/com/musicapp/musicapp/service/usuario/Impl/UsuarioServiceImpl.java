package com.musicapp.musicapp.service.usuario.Impl;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDetalleDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.dto.usuario.UsuarioConDetalleListasDto;
import com.musicapp.musicapp.dto.usuario.UsuarioDto;
import com.musicapp.musicapp.entity.Cancion;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.entity.Usuario;
import com.musicapp.musicapp.mapper.cancion.CancionMapper;
import com.musicapp.musicapp.mapper.listaDeReproduccion.ListaDeReproduccionMapper;
import com.musicapp.musicapp.mapper.usuario.UsuarioMapper;
import com.musicapp.musicapp.repository.listaDeReproduccion.ListaDeReproduccionRepository;
import com.musicapp.musicapp.repository.usuario.UsuarioRepository;
import com.musicapp.musicapp.service.listaDeReproduccion.ListaDeReproduccionService;
import com.musicapp.musicapp.service.usuario.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Transactional
@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final ListaDeReproduccionService listaDeReproduccionService;

    @Override
    public void crearUsuarioConListas(UsuarioDto usuarioDto) {
        Usuario nuevoUsuario = UsuarioMapper.mapToUsuario(usuarioDto, new Usuario());
        nuevoUsuario.setId(UUID.randomUUID());
        nuevoUsuario.setCreadoPor("Admin");
        nuevoUsuario.setCreadoEn(LocalDateTime.now());
        usuarioRepository.save(nuevoUsuario);
        listaDeReproduccionService.crearListasDeReproduccion(usuarioDto.getListaDeReproduccionDto(),nuevoUsuario);

    }

    @Override
    public UsuarioConDetalleListasDto obtenerUsuarioPorId(UUID idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("No se encontro usuario con ID: " + idUsuario));

        UsuarioConDetalleListasDto usuarioDto = UsuarioMapper.mapToUsuarioConDetalleListasDto(usuario, new UsuarioConDetalleListasDto());
        List<ListaDeReproduccionDetalleDto> detalleListasDto = new ArrayList<>();
        for (ListaDeReproduccion lista: usuario.getListaDeReproduccion()) {
            ListaDeReproduccionDetalleDto listaDto = ListaDeReproduccionMapper.mapToListaDeReproduccionDetalleDto(lista,new ListaDeReproduccionDetalleDto());
            detalleListasDto.add(listaDto);
        }
        usuarioDto.setListaDeReproduccionDetalleDtos(detalleListasDto);
        return usuarioDto;
    }

    @Override
    public boolean eliminarUsuarioPorId(UUID idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(()-> new RuntimeException("No se encontro usuario con id " + idUsuario));
        listaDeReproduccionService.eliminarListas(usuario.getListaDeReproduccion());
        usuarioRepository.delete(usuario);
        return Boolean.TRUE;
    }

}
