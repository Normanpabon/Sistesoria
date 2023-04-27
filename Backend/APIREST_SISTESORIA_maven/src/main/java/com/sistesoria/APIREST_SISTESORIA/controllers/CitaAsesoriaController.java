package com.sistesoria.APIREST_SISTESORIA.controllers;

import com.sistesoria.APIREST_SISTESORIA.DTO.CitaAsesoria;
import com.sistesoria.APIREST_SISTESORIA.repository.CitaAsesoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/V1/cita/")
public class CitaAsesoriaController {

    @Autowired
    private CitaAsesoriaRepository citaAsesoriaRepository;


    // GETS

    // Buscar citas agendadas para una asesoria
    // TODO: Realizar filtro para fecha o busqueda por asesoria y fecha
    @GetMapping("/asesoria/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CitaAsesoria> getAllCitasByAsesoria(@PathVariable int id){
        return citaAsesoriaRepository.getAllCitasByAsesoria(id);
    }

    // Buscar citas agendadas por un estudiante
    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CitaAsesoria> getAllCitasByEstudiante(@PathVariable int id){
        return citaAsesoriaRepository.getAllCitasByEstudiante(id);
    }

    // Buscar cita por id del curso y fecha
    // TODO: Realizar logica de busqueda en sql

    // Recuperar los id de estudiante y asistencia dados un id_asesoria y fecha
    // TODO: Realizar logica de busqueda en sql


    // POSTS

    // TODO: Verificar que el estudiante y la asesoria existan. Hacer manejo de errores
    @PostMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<CitaAsesoria> addCitaAsesoria(@RequestBody CitaAsesoria citaAsesoria){
        return citaAsesoriaRepository.save(citaAsesoria);
    }


    // UPDATES

    // Modificar el campo de aprobacion de una cita
    // TODO: Verificar que solo el profesor (rol 0) pueda aprobar la asesoria

    // Modificar la asistencia de un campo de asesoria
}
