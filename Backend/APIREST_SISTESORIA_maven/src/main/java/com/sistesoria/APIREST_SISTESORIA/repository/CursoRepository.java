package com.sistesoria.APIREST_SISTESORIA.repository;

import com.sistesoria.APIREST_SISTESORIA.DTO.Curso;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CursoRepository extends R2dbcRepository<Curso, Long> {

    // Obtener cursos dictados por un profesor

    @Query("SELECT * FROM curso WHERE curso.codigo_profesor:=idProfesor")
    Flux<Curso> getCursosByProfesorId(int idProfesor);

    // Obtener cursos dictados para una asignaura

    @Query("SELECT * FROM curso WHERE curso.codigo_asignatura:=codigo")
    Flux<Curso> getCursosByAsignatura(int codigo);
}
