package com.musicapp.musicapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
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
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.ALL})
    private Genero genero;
    //@Column(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.ALL})
    private Artista artista;
    private String album;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.ALL})
    @JoinTable(name = "listas_canciones", joinColumns = @JoinColumn(name = "cancion_id"),
    inverseJoinColumns = @JoinColumn(name = "lista_id"))
    private List<ListaDeReproduccion> listas = new ArrayList<>();

}
