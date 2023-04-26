package com.sistesoria.APIREST_SISTESORIA.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitaAsesoria {
    @Id
    private int id;

    @Transient
    private int id_asesoria;

    @Transient
    private int id_estudiante;

    private Date fecha;

    private Timestamp hora_inicio;

    private Timestamp hora_fin;

    private Boolean aprobada;

    private Boolean asistio;


}
