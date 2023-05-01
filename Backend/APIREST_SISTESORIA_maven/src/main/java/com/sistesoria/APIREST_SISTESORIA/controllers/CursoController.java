package com.sistesoria.APIREST_SISTESORIA.controllers;

import com.sistesoria.APIREST_SISTESORIA.DTO.Curso;
import com.sistesoria.APIREST_SISTESORIA.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin
@RequestMapping("/V1/curso/")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    // GETS


    // Recuperar todos los cursos
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Curso> getAllCursos(){
        return cursoRepository.findAll();
    }

    // Obtener cursos de profesor
    @GetMapping("prof/{idProfe}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Curso> getCursosByProfesorId(@PathVariable int idProfe){
        return cursoRepository.getCursosByProfesorId(idProfe);
    }

    // Obtener cursos dictados para una asinatura (id asignatura)
    @GetMapping("asignatura/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Curso> getCursosByAsignaturaId(@PathVariable int codigo){
        return cursoRepository.getCursosByAsignatura(codigo);
    }

    // Obtener informacion del curso por su id (PK)
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Curso> getCursoById(@PathVariable long id){
        return cursoRepository.findById(id);
    }

    // POSTS

    // Todo: Manejo de errores para las llaves foraneas
    // Todo : Verificar
    // Agregar un nuevo curso, se espera JSON segun DTO curso, con los datos
    @PostMapping("add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Curso> addCurso(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }


    // UPDATES
    // TODO : Terminar logica
    /*
    //Modificar profesor a cargo del curso
    @PutMapping("/update/{id}/{profesorId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Curso> updateProfesorId(@PathVariable int id, @PathVariable int profesorId){
        return cursoRepository.findById()
    }*/


    // DELETES

}
