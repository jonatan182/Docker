FROM tomcat:7.0.68-jre7

MAINTAINER http://www.imix.com.co

COPY mysql-connector-java-5.1.26.jar /usr/local/tomcat/mysql-connector-java-5.1.26.jar
COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml

EXPOSE 8080

CMD ["catalina.sh", "run"]