package com.sistesoria.APIREST_SISTESORIA.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Asesoria {


    @Id
    private int id;

   // @Transient
    private int codigo_curso;

    private int dia;  //Hacer control del rango de 1 a 7

    private Timestamp hora_inicio;

    private Timestamp hora_fin;

    private String ubicacion;

    private int cupos;
}
