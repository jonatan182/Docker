# Contenedor JIRA #

Este repositorio contiene los archivos necesarios para ejecutar un contenedor con Jira 7.

### Prerequisitos ###

* Máquina Linux con Docker Server instalado
  Una guía para el tamaño de la máquina linux se puede encontrar en [Guía de Tamaño JIRA](https://confluence.atlassian.com/enterprise/jira-sizing-guide-461504623.html), en este caso se ha elegido el tamaño D2 en Azure. jiraimix.cloudapp.net con credenciales jira/JiraImix2016
* Habilitar los puertos 22, 8080 y 4040 (opcional para wavescope)

### Instalación ###

* Conectarse a la máquina Linux (ssh) donde se tiene instalado JIRA descargar el proyecto jira7

1. git clone https://<nombre_usuario>@bitbucket.org/imixconsulting/jira7.git 

2. Entrar a la carpeta mysql-jira y lanzar el archivo docker-compose.yml con el comando docker-compose up -d

3. Entrar a la carpeta jira y lanzar el archivo docker-compose.yml con el comando docker-compose up -d


4. Opcionalmente instalar [wave scope](https://www.weave.works/install-weave-scope/)


    4.1 sudo wget -O /usr/local/bin/scope https://git.io/scope

    4.2 sudo chmod a+x /usr/local/bin/scope

    4.3 sudo scope launch

    4.4 ingresar por medio de un navegador a la ruta de la máquina en el puerto 4040 para ver los contenedores instalados

5. Ingresar la llave de licencia de Jira

6. Ingresar por navegador a la página de Jira, se solicitará configurar los datos de la base de datos, en este caso los que están configurados en el archivo docker-compose.yml de jira y createdb.sh de mysql-jira

    Database host: jiradb

    Database name: jiradb

    User name: jira

    User password: Imix2016


7. Al terminar la configuración inicial de Jira, instalar los siguientes complementos

    7.1 Zephir

    7.2 Tempo

### Contacto en caso de dudas ###

* Jorge Emilio Roa