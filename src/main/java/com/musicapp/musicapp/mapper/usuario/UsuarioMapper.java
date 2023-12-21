package com.musicapp.musicapp.mapper.usuario;

import com.musicapp.musicapp.dto.usuario.UsuarioConDetalleListasDto;
import com.musicapp.musicapp.dto.usuario.UsuarioDto;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.entity.Usuario;
import com.musicapp.musicapp.repository.listaDeReproduccion.ListaDeReproduccionRepository;
import lombok.Data;

import java.util.List;

@Data
public class UsuarioMapper {
    public static Usuario mapToUsuario(UsuarioDto usuarioDto, Usuario usuario){
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setUsuario(usuarioDto.getUsuario());
        return usuario;
    }
    public static UsuarioDto mapToUsuarioDto(Usuario usuario, UsuarioDto usuarioDto){
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setUsuario(usuario.getUsuario());
        return usuarioDto;
    }
    public static UsuarioConDetalleListasDto mapToUsuarioConDetalleListasDto(Usuario usuario, UsuarioConDetalleListasDto usuarioDto){
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setUsuario(usuario.getUsuario());
        return usuarioDto;
    }
}
