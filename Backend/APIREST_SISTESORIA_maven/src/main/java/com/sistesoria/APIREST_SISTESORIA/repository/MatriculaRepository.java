package com.sistesoria.APIREST_SISTESORIA.repository;

import com.sistesoria.APIREST_SISTESORIA.DTO.Matricula;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MatriculaRepository extends R2dbcRepository<Matricula, Long> {

    // Encontrar todas las matriculas de un estudiante
    @Query("SELECT * FROM sistesorias.matricula WHERE sistesorias.matricula.id_estudiante:=idEstudiante")
    Flux<Matricula> getMatriculasByEstudianteId(int idEstudiante);

    // Recuperar todas las matriculas para el id de un curso

    @Query("SELECT * FROM matricula WHERE matricula.id_estudiante:=idCurso")
    Flux<Matricula> getMatriculasByCursoId(int idCurso);
}
