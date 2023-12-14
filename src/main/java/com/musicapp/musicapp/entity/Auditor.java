package com.musicapp.musicapp.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

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
