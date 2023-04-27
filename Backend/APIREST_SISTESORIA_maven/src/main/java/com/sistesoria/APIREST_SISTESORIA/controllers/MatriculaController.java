package com.sistesoria.APIREST_SISTESORIA.controllers;

import com.sistesoria.APIREST_SISTESORIA.DTO.Matricula;
import com.sistesoria.APIREST_SISTESORIA.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/V1/matricula/")
public class MatriculaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    // GETS

    // Obtener matriculas actuales de estudiante por su id (PK) (materias matriculadas por estudiante)
    @GetMapping("/estudiante/{id}")
    @ResponseStatus(HttpStatus.OK)
    Flux<Matricula> getMatriculaByIdEstudiante(@PathVariable int id){
        return matriculaRepository.getMatriculasByEstudianteId(id);
    }

    // Obtener matriculas realizadas a un curso (id del curso)
    @GetMapping("/curso/{idCurso}")
    @ResponseStatus(HttpStatus.OK)
    Flux<Matricula> getMatriculasByIdCurso(@PathVariable int idCurso){
        return matriculaRepository.getMatriculasByCursoId(idCurso);
    }

    // Obtener matricula por su id (PK)
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    Mono<Matricula> getMatriculaById(@PathVariable long id){
        return matriculaRepository.findById(id);
    }

    // POSTS

    // TODO: Manejo de excepcion si no existe el estudiante o el curso a matricular
    // TODO: REVISAR
    // Agrega una nueva matricula, recive json con estructura del DTO Matricula
    @PostMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    Mono<Matricula> saveMatricula(@RequestBody Matricula matricula){
        return matriculaRepository.save(matricula);
    }


    // UPDATES

    // TODO: Realizar metodo para actualizar matricula
    // TODO: Que pasa si un usuario cancela ?
}
