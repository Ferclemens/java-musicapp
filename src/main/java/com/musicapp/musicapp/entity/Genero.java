package com.musicapp.musicapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
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
    @Column(nullable = false)
    private String nombre;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genero", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.ALL})
    private List<Cancion> canciones = new ArrayList<>();
}
