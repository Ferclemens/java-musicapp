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
@Table(name = "Listas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListaDeReproduccion extends Auditor {
    @Id
    @UuidGenerator
    private UUID id;
    //@Column(nullable = false)
    private String nombre;
    //@Column(nullable = false)
    @ManyToOne
    private Usuario usuario;
    @ManyToMany
    @JoinTable(name = "listas_canciones", joinColumns = @JoinColumn(name = "lista_id"),
    inverseJoinColumns = @JoinColumn(name = "cancion_nombre"))
    private List<Cancion> canciones = new ArrayList<>();

}
