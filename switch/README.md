# Creación de Imagen #

Luego de clonar el proyecto e ingresar a la carpeta crear la imagen imix/switch ejecutando el siguiente comando (el punto hace parte del comando)

    - docker build -t imix/switch .


### Ejecución del contenedor ###

Existe varios ejemplos de docker-compose, donde se puede ver varias combinaciones de ejecutar ciertas combinaciones de los switches.

Para ejecutar la configuración que está en docker-compose.yml el cual es el archivo por defecto se ejecuta el siguiente comando:

    - docker-compose up -d

Para ejecutar la configuración que está en otro archivo se debe agregar el parametro -f y el nombre del archivo, un ejemplo a continuación:

    - docker-compose -f docker-compose-transacciones.yml up -d


### Verificación ###

Este contenedor se utiliza para desplegar switches para verificar enviar una prueba al puerto configurado y esperar la respuesta del switch
