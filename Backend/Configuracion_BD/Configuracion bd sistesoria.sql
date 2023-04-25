DROP DATABASE Sistesoria;

DROP USER 'sistesoriaAdmin';

CREATE DATABASE Sistesoria;

use Sistesoria;

CREATE USER 'sistesoriaAdmin' IDENTIFIED BY 'wikitiSistesoria';

GRANT ALL PRIVILEGES ON Sistesoria.* to 'sistesoriaAdmin';

/* Crear tabla de usuarios*/

CREATE TABLE Sistesoria.USUARIO(id int AUTO_INCREMENT, codigo_institucional int, nombre varchar(64),
    apellido varchar(64), usuario varchar(64), correo varchar(64), rol int, foto_perfil BLOB,
    hashed_password varchar(1024), PRIMARY KEY(id),  CONSTRAINT UNQ_username UNIQUE(username, correo, cod_ins));

/* Crear tabla de asignatura */


/* Crear tabla de curso */

/* Crear tabla de matricula */

/* Crear tabla de asesoria */

/* Crear tabla de cita_asesoria */


/* Crear tabla de mensaje */
