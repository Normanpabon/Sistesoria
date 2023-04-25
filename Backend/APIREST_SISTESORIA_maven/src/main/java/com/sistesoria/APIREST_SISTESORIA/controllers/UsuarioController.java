package com.sistesoria.APIREST_SISTESORIA.controllers;

import com.sistesoria.APIREST_SISTESORIA.DTO.LoginForm;
import com.sistesoria.APIREST_SISTESORIA.DTO.Usuario;
import com.sistesoria.APIREST_SISTESORIA.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.sistesoria.APIREST_SISTESORIA.controllers.UsuarioController;

@RestController
@RequestMapping("/V1/usuario/")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    // crear metodos para api usuarios

    // Todo: Validar esquema JSON recivido por el front

    // Login
    // Todo : Verificar funcionamiento de formulario
    // Todo : Crear validadores de tipos de dato
    // Todo : Hashear la clave enviada para validar con bd
    @PostMapping("/Login/")
    Mono<Long> login(@RequestBody LoginForm loginForm){
        return usuarioRepository.verificarLogin(loginForm.getUsuario(), loginForm.getPassword());
    }

    // Todo: borrar luego, solo para pruebas
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    Flux<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }



}
