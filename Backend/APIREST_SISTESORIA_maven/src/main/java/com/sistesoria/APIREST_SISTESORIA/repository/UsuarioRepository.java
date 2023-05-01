package com.sistesoria.APIREST_SISTESORIA.repository;

import com.sistesoria.APIREST_SISTESORIA.DTO.Usuario;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UsuarioRepository extends R2dbcRepository<Usuario, Long> {

    // Obtener ultimo usuario creado
    @Query("SELECT * FROM usuario ORDER BY id DESC LIMIT 1")
    Mono<Usuario> getLastUserAdded();

    // Obtener usuario por username
    @Query("SELECT * FROM usuario WHERE usuario.usuario=:user")
    Mono<Usuario> getUserByUsername(String user);

    // Obtener usuario por codigo institucional

    @Query("SELECT * FROM usuario WHERE usuario.codigo_institucional=:codigo_institucional")
    Mono<Usuario> getUserByUaoCode(int codigo_institucional);

    @Query("SELECT IFNULL( (SELECT usuario.id FROM usuario WHERE usuario.usuario=:user) , -1)")
    Mono<Long> getUserIdByUsername(String user);

    // Devuelve id del usuario si el nombre de usuario y contra son correctas, caso contrario devuelve -1
    @Query("SELECT IFNULL( (SELECT usuario.id FROM usuario WHERE usuario.usuario=:usuario AND usuario.hashed_password=:pass) , -1)")
    Mono<Long> verificarLogin(String username, String pass);

    // Devuelve id del rol del usuario
    @Query("SELECT usuario.rol FROM usuario WHERE usuario.id=:id")
    Mono<Long> getRolByUserId(Long id);

    //Devolver todos los profesores
    @Query("SELECT * FROM usuario WHERE usuario.rol=:rolId")
    Flux<Usuario> getAllProfesores(int rolId);
    @Query("SELECT usuario.rol FROM usuario WHERE usuario.usuario=:user")
    Mono<Long> getRolByUsername(String user);
}
