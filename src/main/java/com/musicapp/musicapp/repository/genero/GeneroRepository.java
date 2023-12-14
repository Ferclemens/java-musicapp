package com.musicapp.musicapp.repository.genero;

import com.musicapp.musicapp.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, UUID> {
}
