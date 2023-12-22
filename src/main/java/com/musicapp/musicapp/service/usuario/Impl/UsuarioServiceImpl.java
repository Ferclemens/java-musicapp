package com.musicapp.musicapp.service.usuario.Impl;

import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDetalleDto;
import com.musicapp.musicapp.dto.listaDeReproduccion.ListaDeReproduccionDto;
import com.musicapp.musicapp.dto.usuario.UsuarioConDetalleListasDto;
import com.musicapp.musicapp.dto.usuario.UsuarioDto;
import com.musicapp.musicapp.entity.Cancion;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.entity.Usuario;
import com.musicapp.musicapp.mapper.listaDeReproduccion.ListaDeReproduccionMapper;
import com.musicapp.musicapp.mapper.usuario.UsuarioMapper;
import com.musicapp.musicapp.repository.listaDeReproduccion.ListaDeReproduccionRepository;
import com.musicapp.musicapp.repository.usuario.UsuarioRepository;
import com.musicapp.musicapp.service.cancion.CancionService;
import com.musicapp.musicapp.service.listaDeReproduccion.ListaDeReproduccionService;
import com.musicapp.musicapp.service.usuario.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Transactional
@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ListaDeReproduccionRepository listaDeReproduccionRepository;
    private final ListaDeReproduccionService listaDeReproduccionService;
    private final CancionService cancionService;

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
    public void crearListaDeReproduccion(ListaDeReproduccionDto listaDeReproduccionDto, UUID idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("No se encontro el usuario con id " + idUsuario));
        ListaDeReproduccion listaNueva = ListaDeReproduccionMapper.mapToListaDeReproduccion(listaDeReproduccionDto, new ListaDeReproduccion());
        listaNueva.setId(UUID.randomUUID());
        listaNueva.setCreadoPor("Admin");
        listaNueva.setCreadoEn(LocalDateTime.now());
        listaNueva.setUsuario(usuario);
        listaNueva.setRepetir(false);
        listaNueva.setAleatorio(false);
        listaNueva.setPublica(true);
        List<Cancion> canciones = cancionService.crearCanciones(listaDeReproduccionDto.getCancionesDto(), new ArrayList<>());
        listaNueva.setCanciones(canciones);
        listaDeReproduccionRepository.save(listaNueva);
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

}
