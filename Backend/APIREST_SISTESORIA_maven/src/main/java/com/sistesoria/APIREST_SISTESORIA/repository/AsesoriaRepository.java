package com.sistesoria.APIREST_SISTESORIA.repository;

import com.sistesoria.APIREST_SISTESORIA.DTO.Asesoria;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AsesoriaRepository extends R2dbcRepository<Asesoria, Long> {

    // Encontrar todas las asesorias de un curso
    @Query("SELECT * FROM asesoria where asesoria.codigo_curso:=idCurso")
    Flux<Asesoria> getAllAsesoriasByCourse(int idCurso);

}
