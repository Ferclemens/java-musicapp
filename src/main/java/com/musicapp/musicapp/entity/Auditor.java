package com.musicapp.musicapp.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@MappedSuperclass // Supperclass for any entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auditor {
    private LocalDateTime createdIn;
    private String createdBy;
    private LocalDateTime modifiedIn;
    private String modifiedBy;
}
