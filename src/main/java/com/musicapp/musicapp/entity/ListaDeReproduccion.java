package com.musicapp.musicapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Listas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListaDeReproduccion extends Auditor {
    @Id
    @UuidGenerator
    @Column(name = "lista_id")
    private UUID id;
    //@Column(nullable = false)
    private String nombre;
    //@Column(nullable = false)
    @ManyToOne
    private Usuario usuario;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.ALL})
    @JoinTable(name = "listas_canciones", joinColumns = @JoinColumn(name = "lista_id"),
    inverseJoinColumns = @JoinColumn(name = "cancion_id"))
    private List<Cancion> canciones = new ArrayList<>();
    private boolean Publica;
    private boolean Repetir;
    private boolean Aleatorio;

}
