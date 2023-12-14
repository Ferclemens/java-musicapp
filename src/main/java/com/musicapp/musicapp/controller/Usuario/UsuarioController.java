package com.musicapp.musicapp.controller.Usuario;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/usuarios", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UsuarioController {

}
