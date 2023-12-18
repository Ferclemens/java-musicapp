package com.musicapp.musicapp.service.genero.Impl;

import com.musicapp.musicapp.dto.genero.GeneroDto;
import com.musicapp.musicapp.entity.Genero;
import com.musicapp.musicapp.mapper.genero.GeneroMapper;
import com.musicapp.musicapp.repository.genero.GeneroRepository;
import com.musicapp.musicapp.service.genero.GeneroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class GeneroServiceImpl implements GeneroService {
    private final GeneroRepository generoRepository;
    @Override
    public Genero crearGenero(GeneroDto generoDto, Genero genero) {
        Genero generoCreado = GeneroMapper.mapToGenero(generoDto, genero);
        generoCreado.setId(UUID.randomUUID());
        generoRepository.save(generoCreado);
        return generoCreado;
    }
}
