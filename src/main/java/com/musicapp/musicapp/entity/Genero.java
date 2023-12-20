package com.musicapp.musicapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "Genero")
@AllArgsConstructor
@NoArgsConstructor
//@Data
@Getter
@Setter
public class Genero {
    @Id
    @UuidGenerator
    private UUID id;
    //@Column(nullable = false)
    private String nombre;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genero", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Cancion> canciones = new ArrayList<>();
}
