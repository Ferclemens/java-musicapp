package com.musicapp.musicapp.dominio;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@MappedSuperclass // Supperclass para todas las entidades
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auditor {
    private LocalDateTime creadoEn;
    private String creadoPor;
    private LocalDateTime modificadoEn;
    private String modificadoPor;
}
