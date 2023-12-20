package com.musicapp.musicapp.service.genero.Impl;

import com.musicapp.musicapp.dto.genero.GeneroDto;
import com.musicapp.musicapp.entity.Genero;
import com.musicapp.musicapp.mapper.genero.GeneroMapper;
import com.musicapp.musicapp.repository.genero.GeneroRepository;
import com.musicapp.musicapp.service.genero.GeneroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class GeneroServiceImpl implements GeneroService {
    private final GeneroRepository generoRepository;
    @Override
    public Genero crearGenero(String generoDto, Genero genero) {
        Genero generoCreado = new Genero();
        generoCreado = GeneroMapper.mapToGenero(generoDto, genero);
        generoCreado.setId(UUID.randomUUID());
        generoRepository.save(generoCreado);
        return generoCreado;

//        Genero generoCreado = new Genero();
//        List<Genero> listaDeGeneros = generoRepository.findAll();
//        if (listaDeGeneros.isEmpty()){
//            generoCreado = GeneroMapper.mapToGenero(generoDto, genero);
//            generoCreado.setId(UUID.randomUUID());
//        } else {
//            for (Genero generoDB: listaDeGeneros) {
//                if(generoDB.getNombre() == generoDto.getNombre()){
//                    generoCreado = generoDB;
//                } else {
//                    generoCreado = GeneroMapper.mapToGenero(generoDto, genero);
//                    generoCreado.setId(generoDB.getId());
//                }
//            }
//        }
//        generoRepository.save(generoCreado);
//        return generoCreado;
    }
}
