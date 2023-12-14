package com.musicapp.musicapp.repository.cancion;

import com.musicapp.musicapp.entity.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, UUID> {
}
