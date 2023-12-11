package com.musicapp.musicapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "Genero")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Genero {
    @Id
    @UuidGenerator
    private UUID id;
    //@Column(nullable = false)
    private String nombre;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genero", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Cancion> canciones = new ArrayList<>();
}
