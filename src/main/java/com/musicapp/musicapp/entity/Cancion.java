package com.musicapp.musicapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "Cancion")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cancion {
    @Id
    @UuidGenerator
    private UUID id;
    //@Column(nullable = false)
    private String nombre;
    private int ranking;
    //@Column(nullable = false)
    private Double duracion;
    //@Column(nullable = false)
    @ManyToOne
    private Genero genero;
    //@Column(nullable = false)
    @ManyToOne
    private Artista artista;
    private String album;
    @ManyToMany
    @JoinTable(name = "listas_canciones", joinColumns = @JoinColumn(name = "cancion_nombre"),
    inverseJoinColumns = @JoinColumn(name = "lista_id"))
    private List<ListaDeReproduccion> listas = new ArrayList<>();

}
