package com.musicapp.musicapp.bootstrap;

import com.musicapp.musicapp.entity.Artista;
import com.musicapp.musicapp.entity.ListaDeReproduccion;
import com.musicapp.musicapp.entity.Usuario;
import com.musicapp.musicapp.repository.artista.ArtistaRepository;
import com.musicapp.musicapp.repository.cancion.CancionRepository;
import com.musicapp.musicapp.repository.genero.GeneroRepository;
import com.musicapp.musicapp.repository.listaDeReproduccion.ListaDeReproduccionRepository;
import com.musicapp.musicapp.repository.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private ArtistaRepository artistaRepository;
    private CancionRepository cancionRepository;
    private GeneroRepository generoRepository;
    private ListaDeReproduccionRepository listaDeReproduccionRepository;
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        cargarUsuario();
//        cargarListaDeReproduccion();
    }
    private void cargarUsuario(){
        Usuario usuario1 = new Usuario();
        usuario1.setId(UUID.randomUUID());
        usuario1.setNombre("Fernando");
        usuario1.setUsuario("Chufakka");
        usuario1.setCreadoEn(LocalDateTime.now());
        usuario1.setCreadoPor("Fernando");

        usuarioRepository.save(usuario1);
    }
//    private void cargarListaDeReproduccion() {
//        ListaDeReproduccion lista1 = new ListaDeReproduccion();
//        lista1.setId(UUID.randomUUID());
//        lista1.setNombre("ListaDeTemas");
//        lista1.setUsuario();
//    }
//    private void cargarArtista(){
//        Artista artista1 = new Artista();
//        artista1.setId(UUID.randomUUID());
//        artista1.setNombre("Daft Punk");
//        artista1.setCanciones(List.of(cancionRepository.));
//    }
}
