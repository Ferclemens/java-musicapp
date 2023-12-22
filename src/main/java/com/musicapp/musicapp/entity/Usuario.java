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
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

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
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String usuario;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<ListaDeReproduccion> listaDeReproduccion = new ArrayList<>();
}
