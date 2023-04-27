package com.sistesoria.APIREST_SISTESORIA.repository;


import com.sistesoria.APIREST_SISTESORIA.DTO.CitaAsesoria;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CitaAsesoriaRepository extends R2dbcRepository<CitaAsesoria, Long> {


    // Buscar citas agendadas por id de espacio asesoria
    // TODO: Realizar filtro para fecha o busqueda por asesoria y fecha
    @Query("SELECT * FROM cita_asesoria WHERE cita_asesoria.id_asesoria:=idAsesoria")
    Flux<CitaAsesoria> getAllCitasByAsesoria(int idAsesoria);

    // Buscar citas agendadas por un estudiante
    @Query("SELECT * FROM cita_asesoria WHERE cita_asesoria.id_estudiante:=idEstudiante")
    Flux<CitaAsesoria> getAllCitasByEstudiante(int idEstudiante);

    // Buscar cita por id del curso y fecha
    // TODO: Realizar logica de busqueda en sql


}
