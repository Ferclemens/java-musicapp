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
//@Data
//https://stackoverflow.com/questions/40266770/spring-jpa-bi-directional-cannot-evaluate-tostring
@Setter
@Getter
public class Cancion {
    @Id
    @UuidGenerator
    @Column(name = "cancion_id")
    private UUID id;
    //@Column(nullable = false)
    private String nombre;
    private int ranking;
    //@Column(nullable = false)
    private Double duracion;
    //@Column(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Genero genero;
    //@Column(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Artista artista;
    private String album;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "listas_canciones", joinColumns = @JoinColumn(name = "cancion_id"),
    inverseJoinColumns = @JoinColumn(name = "lista_id"))
    private List<ListaDeReproduccion> listas = new ArrayList<>();

}
