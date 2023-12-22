package com.musicapp.musicapp.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@MappedSuperclass // Supperclass para todas las entidades
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Auditor {
    private LocalDateTime creadoEn;
    private String creadoPor;
    private LocalDateTime modificadoEn;
    private String modificadoPor;
}
