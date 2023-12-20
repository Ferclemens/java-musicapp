package com.musicapp.musicapp.repository.cancion;

import com.musicapp.musicapp.entity.Artista;
import com.musicapp.musicapp.entity.Cancion;
import com.musicapp.musicapp.entity.Genero;
import com.musicapp.musicapp.mapper.cancion.CancionMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, UUID> {
    List<Cancion> findByNombreStartingWith(String nombre);
//    List<Cancion> findByGeneroStartingWith(String genero);
//    List<Cancion> findByArtistaStartingWith(String artista);
    List<Cancion> findByAlbumStartingWith(String album);


}
