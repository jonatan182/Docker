# pull a imagen #

docker pull zheiro/jdk8-jboss-eap7

### Que hacer con jboss_eap_dev ###

1. Copiar la carpeta jboss_eap_dev en la maquina donde va a estar el docker, en este caso la 112
2. Colocarse dentro de la carperta jboss_eap_dev y ejecutar el comando:
   * docker-compose -p #nombre -f docker-#archivoCompose up -d --force-recreate
 Ejemplo: 
   **docker-compose -p jboss_eap_7 -f docker-compose.yml up -d --force-recreate**