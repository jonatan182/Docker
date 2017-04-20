# Contenedor Wildfly #

En este proyecto se encuentra la configuración de un contenedor docker de wildfly para varios proyectos.

En este proyecto en particular se utiliza una característica de docker que permite heredar desde un Dockerfile en otro y que se realicen ciertas tareas en tiempo de creación de la imagen. Es por esto que existe un Dockerfile por cada proyecto, es decir un Dockerfile por cada uno de los proyectos, publico, cores y wrappers.

Nota: Debido a que los proyectos core y wrappers actualmente se ejecutan en glassfish, dichos proyectos no se pueden desplegar en este contenedor Wildfly, para esto se debe modificar esos proyectos para que sean desplegables.

### Creación de la imagen ###

Para crear una imagen de cierto proyecto se debe ingresar a la carpeta respectiva y ejecutar el comando docker build y dar un nombre específico. Por ejemplo ingresar a la carpeta cores/AdminCore y ejecutar el comando

    - docker build -t imix/admincore .

Con esto se creará la imagen para desplegar AdminCore, la diferencia entre los diferentes proyectos es el archivo config.cli, el cual contiene la configuración de módulos específica para uno, por ejemplo los datasources necesarios para una conexión de base de datos.

### Ejecución del contenedor ###

Para ejecutar cierta combinación de proyectos existe como ejemplo el archivo docker-compose.yml, en este se define como se ejecutan los contenedores, y con parámetro link se puede crear un enlace entre ellos para que tengan una conexión, se puede crear otro archivo con otra combinación, y en ese caso se puede ejecutar usando el parámetro -f de docker-compose, si el archivo se llamara docker-compose-transacciones.yml se ejecuta el siguiente comandos:

    - docker-compose -f docker-compose-transacciones.yml up -d

Sino, y se quiere usar el archivo de nombre docker-compose por defecto, se usa:

    - docker-compose up -d

 