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
public class Mensaje {

    @Id
    private int id;

    @Transient
    private int id_receptor;

    @Transient
    private int id_emisor;

    private String mensaje;

    //private byte[] adjunto;

    private Date fecha_envio;

}
