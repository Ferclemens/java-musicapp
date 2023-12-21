package com.musicapp.musicapp.repository.listaDeReproduccion;

import com.musicapp.musicapp.entity.ListaDeReproduccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ListaDeReproduccionRepository extends JpaRepository<ListaDeReproduccion, UUID> {

    ListaDeReproduccion findByNombreStartingWith(String nombre);
}
