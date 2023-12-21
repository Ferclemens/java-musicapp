package com.musicapp.musicapp.repository.artista;

import com.musicapp.musicapp.entity.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ArtistaRepository extends JpaRepository<Artista, UUID> {
    Artista findByNombreStartingWith(String nombre);
}
