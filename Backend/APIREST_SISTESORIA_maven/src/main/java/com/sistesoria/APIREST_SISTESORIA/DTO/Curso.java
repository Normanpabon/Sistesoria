package com.sistesoria.APIREST_SISTESORIA.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Curso {

    @Id
    private int id;

    //Verificar notacion
    @Transient
    private int codigo_asignatura;

    @Transient
    private int codigo_profesor;

    private Date fecha_cierre;

}
