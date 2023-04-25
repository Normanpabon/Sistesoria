package com.sistesoria.APIREST_SISTESORIA.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginForm {

    // Todo : Revisar si es realmente necesario separar el DTO de inicio de session

    private String usuario;

    private String password;
}
