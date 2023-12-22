package com.musicapp.musicapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "Artista")
@AllArgsConstructor
@NoArgsConstructor
//https://projectlombok.org/features/Data
//@Data
@Getter
@Setter
public class Artista {
    @Id
//  https://www.baeldung.com/java-hibernate-uuid-primary-key
//  @GeneratedValue(generator = "uuid-hibernate-generator")
//  @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @UuidGenerator
    private UUID id;
    //@Column(nullable = false)
    private String nombre;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "artista", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.ALL})
    private List<Cancion> canciones = new ArrayList<>();
}
