package com.sistesoria.APIREST_SISTESORIA.controllers;

import com.sistesoria.APIREST_SISTESORIA.DTO.Asignatura;
import com.sistesoria.APIREST_SISTESORIA.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@CrossOrigin
@RequestMapping("/V1/asignatura/")
public class AsignaturaController {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    // GETS
    // Recuperar asignatura por codigo institucional
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Asignatura> getAsignaturaById(@PathVariable Long id){
        return asignaturaRepository.findById(id);
    }

    // Obtener todas las asignaturas

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Asignatura> getAllAsignaturas(){
        return asignaturaRepository.findAll();
    }

    // POSTS

    // Agregar una nueva asignatura
    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Asignatura> addAsignatura(@RequestBody Asignatura asignatura){
        return asignaturaRepository.save(asignatura);
    }


    // DELETE


    // UPDATE
}
