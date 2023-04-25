package com.sistesoria.APIREST_SISTESORIA.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    private int id;

    private int codigo_institucional;

    private String nombre;

    private String apellido;

    private String usuario;

    private String correo;

    private int rol;

    //private byte[] foto_perfil;

    private String hashed_password;


}
