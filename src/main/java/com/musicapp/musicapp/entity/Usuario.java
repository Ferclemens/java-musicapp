package com.musicapp.musicapp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "Usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario extends Auditor {
    @Id
    @UuidGenerator
    private UUID id;
    //@Column(nullable = false)
    private String nombre;
    //@Column(nullable = false)
    private String usuario;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ListaDeReproduccion> listaDeReproduccion = new ArrayList<>();
}
