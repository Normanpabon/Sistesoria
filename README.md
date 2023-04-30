# Manual Sistesoria Alpha 0.1 (Primer Sprint)

## Configuracion del Backend ( SpringBoot ) :

### Creacion tablas en Mysql server 8

 - Abrimos la consola del Mysql Server 8 y pegamos el contenido del archivo **SCRIPT.sql** en la consola
![1](https://raw.githubusercontent.com/Normanpabon/Sistesoria/Frontend/Documentacion/GifSistesoria/CrearTablasyUserBd.gif)
 - Ahora abrimos el documento "Datos de prueba.sql" copiamos y pegamos su contenido en la consola de Mysql, seguido damos enter.
 
 ![2](https://raw.githubusercontent.com/Normanpabon/Sistesoria/Frontend/Documentacion/GifSistesoria/InsertarDatosDePruebaBD.gif)

### Ejeccucion del proyecto de la Api Rest Sistesoria con intellij

 - Nos ubicamos en la carpeta del proyecto, y abrimos la carpeta **"APIREST_SISTESORIA_maven"** como un proyecto de intellij.

![3](https://raw.githubusercontent.com/Normanpabon/Sistesoria/Frontend/Documentacion/GifSistesoria/AbrirCarpetaComoProjecto.gif)

 - Una vez abierto e indexado por Intellij, ejecutamos el proyecto dentro del IDE, verificamos que tengamos instalado y seleccionado la version de Java JDK 17 para el proyecto. Se recomienda la version de OpenJDK Corretto 17.
 
 ![4](https://raw.githubusercontent.com/Normanpabon/Sistesoria/Frontend/Documentacion/GifSistesoria/EjecutarBackendConIntellij.gif)
 - Una vez este corriendo la API, podemos acceder al Swagger o documentacion de OpenAPI de Sistesoria. 

> Aqui podremos ejecutar el comportamiento de obtener los valores de los
> usuarios para probar en el login.

 - Cuando el backend este corriendo podemos acceder desde la url: [http://localhost:8090/SISTESORIA-REST-Docs/swagger](http://localhost:8090/SISTESORIA-REST-Docs/swagger)

![5](https://raw.githubusercontent.com/Normanpabon/Sistesoria/Frontend/Documentacion/GifSistesoria/AbrirSwagger.gif)

## Ejecuccion del Frontend ( React )
Abrimos una consola de windows (CMD) y nos ubicamos en la carpeta del proyecto de react **"Sistesoria\FrontEnd\Sistesoria React"**
##### Nota: Se debe tener instalado node.js para instalar los paquetes necesarios

 - Comando para consola : `cd Sistesoria\FrontEnd\Sistesoria React`( complete la url segun su carpeta).
 - Luego estando en la carpeta del proyecto, ejecute el comando `npm install `, esto intalara los paquetes necesarios y los actualizara de ser necesario.
 - Una vez instaladas las dependencias, ejecute el proyecto con `npm run dev`, espere el mensaje de que se esta ejecutando en la consola. Luego acceda atravez de la url: [http://localhost:5173/](http://localhost:5173/) desde cualquier navegador al frontend del aplicativo de Sistesoria.

![6](https://raw.githubusercontent.com/Normanpabon/Sistesoria/Frontend/Documentacion/GifSistesoria/EjecutarFrontEnd%28react%29.gif)