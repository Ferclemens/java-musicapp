package com.musicapp.musicapp.controller.artista;

import com.musicapp.musicapp.dto.artista.ArtistaDto;
import com.musicapp.musicapp.entity.Artista;
import com.musicapp.musicapp.repository.artista.ArtistaRepository;
import com.musicapp.musicapp.service.artista.ArtistaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/artistas", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ArtistaController {
    private final ArtistaService artistaService;
    @GetMapping()
    public ResponseEntity<List<ArtistaDto>> obtenerTodosLosArtistas(){
        List<ArtistaDto> artistas = artistaService.obtenerTodosLosArtistas();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(artistas);
    }
    @GetMapping("/{idArtista}")
    //Exploración y búsqueda punto 3
    public ResponseEntity<ArtistaDto> obtenerArtistaPorId(@PathVariable(name = "idArtista")UUID idArtista){
        ArtistaDto artistaDto = artistaService.obtenerArtistaPorId(idArtista);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(artistaDto);
    }
}
