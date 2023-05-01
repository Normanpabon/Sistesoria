package com.sistesoria.APIREST_SISTESORIA.controllers;

import com.sistesoria.APIREST_SISTESORIA.DTO.LoginForm;
import com.sistesoria.APIREST_SISTESORIA.DTO.Usuario;
import com.sistesoria.APIREST_SISTESORIA.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.headers.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.sistesoria.APIREST_SISTESORIA.controllers.UsuarioController;

@RestController
@CrossOrigin
@RequestMapping("/V1/usuario/")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

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

    // Getters

    // Todo: borrar luego, solo para pruebas
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    Flux<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    // Obtener usuario por id institucional

    // TODO: Prevenir el envio del campo de contraseña del usuario en cuestion
    @GetMapping("/UAO/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Usuario> getUserByUaoId(@PathVariable int id){
        return usuarioRepository.getUserByUaoCode(id);
    }

    // Obtener usuario por el nombre de usuario
    // Todo : Prevenir envio de la clave, tambien buscar por correo en query
    @GetMapping("/username/{user}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Usuario> getUserByUsername(@PathVariable String user){
        return usuarioRepository.getUserByUsername(user);
    }

    // Obtener todos los profesores

    @GetMapping("/all/profesores")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Usuario> getAllProfesores(){
        int rolABuscar = 0;
        return usuarioRepository.getAllProfesores(0);
    }

    // Obtener Id (PK) del usuario con su nombre de usuario

    @GetMapping("/userPkId/{user}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Long> getUserIdByUsername(@PathVariable String user){
        return usuarioRepository.getUserIdByUsername(user);
    }


    // Devuelve el id del rol del usuario buscado por su PK
    @GetMapping("/userRolById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Long> getUserRolById(@PathVariable Long id){
        return usuarioRepository.getRolByUserId(id);
    }


    // Devuelve el id del rol del usuario buscado por su nombre usuario
    @GetMapping("/userRolByUser/{user}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Long> getUserRolByUsername(@PathVariable String user){
        return usuarioRepository.getRolByUsername(user);
    }

    // POSTs
    // nota: La creacion y actualizacion de users no esta prevista por falta de administrador






}
