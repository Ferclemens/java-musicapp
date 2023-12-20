package com.musicapp.musicapp.service.genero;

import com.musicapp.musicapp.dto.genero.GeneroDto;
import com.musicapp.musicapp.entity.Genero;

public interface GeneroService {
    Genero crearGenero(String generoDto, Genero genero);
}
