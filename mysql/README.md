# Docker MySQL#

Imagen docker con MySQL, con un contenedor temporal que realiza una restauración de copia de respaldo.

***

### Instrucciones de ejecución ###

* En el archivo __docker-compose.yml__ editar la sección volumes de __mysqlclient:__ cambiar `~/shared/mysql` por la ruta local donde se encuentre la copia o copias de respaldo, se restaurará con los archivos que tengan extensión __.sql__. Los archivos deben contener las instrucciones de creación y uso de las bases de datos.

>    `volumes:`

>        - ~/shared/mysql:/home

* Desde un terminal docker ejecutar el siguiente comando para construir la imagen. Requiere descarga, puede tardar varios minutos

> `docker build -t imix/mysql .`

* Ejecutar los contenedores con la siguiente instrucción

> `docker-compose up -d`

* Con un cliente de base de datos (workbench, dbeaver, squirel, etc.) verificar que funcione el servicio de base de datos con el usuario y password que aparecen en el archivo __docker-compose.yml__ (root/rootpassword por defecto)

### Contacto en caso de tener alguna duda ###

* Jorge Roa