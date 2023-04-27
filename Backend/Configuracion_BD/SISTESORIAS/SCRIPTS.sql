/* SE CREA LA BD*/--
CREATE SCHEMA sistesorias;

-- TABLA USUARIOS
CREATE TABLE sistesorias.usuario (
  ID INT NOT NULL,
  CODIGO_INSTI INT NOT NULL,
  NOMBRE VARCHAR(45) NOT NULL,
  APELLIDO VARCHAR(45) NOT NULL,
  USUSARIO VARCHAR(45) NOT NULL,
  CORREO VARCHAR(45) NOT NULL,
  ROL INT(2) NOT NULL COMMENT '0: PROFESOR 1: ESTUDIANTE',
  HASHED_PASSWORD VARCHAR(45) NOT NULL,
  PRIMARY KEY (ID));
  
  
--TABLA CITA_ASESORIA
CREATE TABLE sistesorias.cita_asesoria (
  ID_CITA INT NOT NULL,
  ID_ASESORIA INT NOT NULL,
  ID_ESTUDIANTE INT NOT NULL,
  FECHA DATE NOT NULL,
  HORA_INICIO TIME NOT NULL,
  HORA_FIN TIME NOT NULL,
  APROBADA TINYINT NOT NULL COMMENT 'S: SI  N: NO',
  ASISTIO TINYINT NOT NULL COMMENT 'S: SI ASITE  N: NO ASISTE',
  PRIMARY KEY (ID_CITA));

-- TABLA ASESORIAS
CREATE TABLE sistesorias.asesoria (
  id_asesoria INT NOT NULL,
  codigo_curso INT NOT NULL,
  DIA INT NOT NULL COMMENT 'EL DÍA DE LA ASESORIA PUEDE SER UN NUMERO ENTRE 1 Y 7 REPRESENTANDO EL DÍA DE LA SEMANA 1=LUNES Y 7=DOMINGO',
  hora_inicio TIME NOT NULL,
  hora_fin TIME NOT NULL,
  ubicacion VARCHAR(45) NOT NULL,
  cupos INT NOT NULL,
  PRIMARY KEY (id_asesoria));
  
--TABLA MENSAJE
CREATE TABLE sistesorias.mensaje (
  ID_MENSAJE INT NOT NULL,
  ID_RECEPTOR INT NOT NULL,
  ID_EMISOR INT NOT NULL,
  MENSAJE VARCHAR(120) NOT NULL,
  FECHA_ENVIO DATE NOT NULL,
  PRIMARY KEY (ID_MENSAJE));

--TABLA MATRICULA
CREATE TABLE sistesorias.matricula (
  id_matricula INT NOT NULL,
  id_estudiante INT NOT NULL,
  id_curso INT NOT NULL,
  PRIMARY KEY (id_matricula))
COMMENT = 'Matricula realacioa a usuario estudiante con los cursos en los cuales se encuentre inscrito		';

--TABLA CURSO
CREATE TABLE sistesorias.curso (
  ID_CURSO INT NOT NULL,
  CODIGO_ASIG INT NOT NULL,
  CODIGO_PROF INT NOT NULL,
  FECHA_CIERRE DATE NOT NULL,
  PRIMARY KEY (ID_CURSO))
COMMENT = 'Para ser dictado por un usuario, este debe tener un rol = 0 profesor';

--TABLA ASIGNATURA 
CREATE TABLE sistesorias.asignatura (
  CODIGO_UAO INT NOT NULL,
  NOMBRE VARCHAR(45) NOT NULL,
  CREDITOS INT NOT NULL,
  PRIMARY KEY (CODIGO_UAO))
COMMENT = 'No se considera la facultad de la asignatura pues no se considera pertinente para el aplicativo ';
 
 -- FK CITA_ASESORIA - ASESORIA
ALTER TABLE sistesorias.cita_asesoria 
ADD CONSTRAINT CITA_AS_ASESORIA
FOREIGN KEY (ID_ASESORIA)
REFERENCES sistesorias.asesoria (id_asesoria);

-- FK CITA_ASESORIA - USUARIO 
ALTER TABLE sistesorias.cita_asesoria 
ADD INDEX CITA_AS_USUARIO_idx (ID_ESTUDIANTE ASC) VISIBLE;
;
ALTER TABLE sistesorias.cita_asesoria 
ADD CONSTRAINT CITA_AS_USUARIO
  FOREIGN KEY (ID_ESTUDIANTE)
  REFERENCES sistesorias.usuario (ID)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--FK CURSO - ASIGNATURA Y USUARIO
ALTER TABLE sistesorias.curso 
ADD INDEX CURSO_ASIG_idx (CODIGO_ASIG ASC) VISIBLE,
ADD INDEX CURSO_USU_idx (CODIGO_PROF ASC) VISIBLE;
;
ALTER TABLE sistesorias.curso 
ADD CONSTRAINT CURSO_ASIG
  FOREIGN KEY (CODIGO_ASIG)
  REFERENCES sistesorias.asignatura (CODIGO_UAO)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT CURSO_USU
  FOREIGN KEY (CODIGO_PROF)
  REFERENCES sistesorias.usuario (ID)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--FK MATRICULA - CURSO Y USUARIO 
ALTER TABLE sistesorias.matricula 
ADD INDEX MATRI-CURSO_idx (id_curso ASC) VISIBLE,
ADD INDEX MATRI-USU_idx (id_estudiante ASC) VISIBLE;
;
ALTER TABLE sistesorias.matricula 
ADD CONSTRAINT MATRI_CURSO
  FOREIGN KEY (id_curso)
  REFERENCES sistesorias.curso (ID_CURSO)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT MATRI_USU
  FOREIGN KEY (id_estudiante)
  REFERENCES sistesorias.usuario (ID)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- FK MENSAJE Y USUARIO -- TENER EN CUENTA QUE EXISTE UN CICLO Y SE DEBIA DE CREAR TABLA DE UNION ENTRE ESTAS DOS TABLAS
ALTER TABLE sistesorias.mensaje 
ADD INDEX ID_RECEP-ID_USU_idx (ID_RECEPTOR ASC) VISIBLE,
ADD INDEX ID_EMISOR-USU_idx (ID_EMISOR ASC) VISIBLE;
;
ALTER TABLE sistesorias.mensaje 
ADD CONSTRAINT ID_RECEP_ID_USU
  FOREIGN KEY (ID_RECEPTOR)
  REFERENCES sistesorias.usuario (ID)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT ID_EMISOR_USU
  FOREIGN KEY (ID_EMISOR)
  REFERENCES sistesorias.usuario (ID)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
 -- FK ASESORIA A CURSO
 ALTER TABLE sistesorias.asesoria 
ADD INDEX ASE_CURSO_idx (codigo_curso ASC) VISIBLE;
;
ALTER TABLE sistesorias.asesoria 
ADD CONSTRAINT ASE_CURSO
  FOREIGN KEY (codigo_curso)
  REFERENCES sistesorias.curso (ID_CURSO)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
