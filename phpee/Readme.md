# Docker PHP#

Imagen docker con PHP y las librerías mínimas para la conexión con MySQL.

***

### Instrucciones de ejecución ###

1. En el archivo __docker-compose.yml__ editar la sección volumes `~/Documents/IMIX/GIT/Portales/getrax` por la ruta local donde se encuentre la copia del sitio web que se desea desplegar, con esto se visualizar en el host de docker el sitio previsto.
2. En el mismo archivo __docker-compose.yml__ editar en la sección de volumes `~/var/log/docker/getrax/apache2` por la ruta local donde se encuentran los logs de la aplicación de apache2

>    `volumes:`

>        - `~/Documents/IMIX/GIT/Portales/getrax:/var/www/site`
>        - `~/var/log/docker/getrax/apache2:/var/log/apache2`

2.1. En el mismo archivo __docker-compose.yml__ editar la sección poprts a conveniencia dependiendo de los puertos que se encuentren ocupados en la maquina virtual de Docker. 

> `ports:`

>       - 82:80
>       - 445:443

3. Asegurarse que exista el docker de MySQL para la base de datos con el nombre __mysql_mysql_1__ los pasos para la instalación de este docker los puede encontrar en la siguiente ruta https://bitbucket.org/imixconsulting/mysql

4. Desde un terminal docker ejecutar el siguiente comando para construir la imagen. Requiere descarga, puede tardar varios minutos. Para ejecutar una terminal de docker basta con abrir la herramienta de __Kitematic__ y hacer click sobre el boton __DOCKER CLI__


> `docker build -t mysite .`

* Ejecutar los contenedores con la siguiente instrucción

> `docker-compose up -d`


### Contacto en caso de tener alguna duda ###

* __Manuel Ramirez__ [manuel.ramirez@imix.com.co](manuel.ramirez@imix.com.co)
* __Jorge Roa__ [jorge.roa@imixservices.com](jorge.roa@imixservices.com)