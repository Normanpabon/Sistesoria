package com.sistesoria.APIREST_SISTESORIA.controllers;

import com.sistesoria.APIREST_SISTESORIA.DTO.Asesoria;
import com.sistesoria.APIREST_SISTESORIA.repository.AsesoriaRepository;
import com.sistesoria.APIREST_SISTESORIA.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/V1/asesoria/")
public class AsesoriaController {

    @Autowired
    private AsesoriaRepository asesoriaRepository;


    // GETS

    // listar todas las asesorias
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Asesoria> getAllAsesorias(){
        return asesoriaRepository.findAll();
    }

    // Listar asesorias para un curso
    @GetMapping("/curso/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Asesoria> getAllAsesoriasByCourse(@PathVariable int id){
        return asesoriaRepository.getAllAsesoriasByCourse(id);
    }

    // Listar cupos disponibles para asesoria ?
    // TODO: REALIZAR


    // POSTS

    // Crear un nuevo espacio de asesoria
    // Todo: verificar que el rol sea de id 0, solo el profesor puede crear espacio
    // Todo: verificar que el profesor que crea la asesoria sea el mismo a cargo del curso

    @PostMapping("add/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Asesoria> createNewAsesoria(@RequestBody Asesoria asesoria){
        return asesoriaRepository.save(asesoria);
    }


    //UPDATES
}
