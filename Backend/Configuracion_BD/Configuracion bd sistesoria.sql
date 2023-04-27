DROP DATABASE Sistesoria;

DROP USER 'sistesoriaAdmin';

CREATE DATABASE Sistesoria;

use Sistesoria;

CREATE USER 'sistesoriaAdmin' IDENTIFIED BY 'wikitiSistesoria';

GRANT ALL PRIVILEGES ON Sistesoria.* to 'sistesoriaAdmin';

/* Crear tabla de usuarios*/

CREATE TABLE Sistesoria.USUARIO(id int AUTO_INCREMENT, codigo_institucional int, nombre varchar(64),
    apellido varchar(64), usuario varchar(64), correo varchar(64), rol int, foto_perfil BLOB,
    hashed_password varchar(1024), PRIMARY KEY(id),  CONSTRAINT UNQ_username UNIQUE(usuario, correo, codigo_institucional));

/* Crear tabla de usuarios SIN BLOB*/

CREATE TABLE Sistesoria.USUARIO(id int AUTO_INCREMENT, codigo_institucional int, nombre varchar(64),
    apellido varchar(64), usuario varchar(64), correo varchar(64), rol int, 
    hashed_password varchar(1024), PRIMARY KEY(id),  CONSTRAINT UNQ_username UNIQUE(usuario, correo, codigo_institucional));

/* Crear tabla de asignatura */

CREATE TABLE Sistesoria.asignatura (
  codigo_uao INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  creditos INT NOT NULL,
  PRIMARY KEY (CODIGO_UAO));


/* Crear tabla de curso */

/* Crear tabla de matricula */

/* Crear tabla de asesoria */

/* Crear tabla de cita_asesoria */


/* Crear tabla de mensaje */
