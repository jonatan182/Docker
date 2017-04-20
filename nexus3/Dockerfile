FROM       centos:centos7
MAINTAINER Imix <jenkins@imix.com.co>

ENV NEXUS_DATA /nexus-data

ENV JKS_PASSWORD Imix2016
ENV NEXUS_DOMAIN getrax.cloudapp.net
ENV NEXUS_IP_ADDRESS 13.84.159.148

ENV NEXUS_VERSION 3.0.0-03

ENV JAVA_HOME /opt/java
ENV JAVA_VERSION_MAJOR 8
ENV JAVA_VERSION_MINOR 77
ENV JAVA_VERSION_BUILD 03

RUN yum install -y \
  curl tar \
  && yum clean all

# install Oracle JRE
RUN mkdir -p /opt \
  && curl --fail --silent --location --retry 3 \
  --header "Cookie: oraclelicense=accept-securebackup-cookie; " \
  http://download.oracle.com/otn-pub/java/jdk/${JAVA_VERSION_MAJOR}u${JAVA_VERSION_MINOR}-b${JAVA_VERSION_BUILD}/server-jre-${JAVA_VERSION_MAJOR}u${JAVA_VERSION_MINOR}-linux-x64.tar.gz \
  | gunzip \
  | tar -x -C /opt \
  && ln -s /opt/jdk1.${JAVA_VERSION_MAJOR}.0_${JAVA_VERSION_MINOR} ${JAVA_HOME}

# install nexus
RUN mkdir -p /opt/sonatype/nexus \
  && curl --fail --silent --location --retry 3 \
    https://download.sonatype.com/nexus/3/nexus-${NEXUS_VERSION}-unix.tar.gz \
  | gunzip \
  | tar x -C /opt/sonatype/nexus --strip-components=1 nexus-${NEXUS_VERSION} \
  && chown -R root:root /opt/sonatype/nexus 

## configure nexus runtime env
RUN sed \
    -e "s|karaf.home=.|karaf.home=/opt/sonatype/nexus|g" \
    -e "s|karaf.base=.|karaf.base=/opt/sonatype/nexus|g" \
    -e "s|karaf.etc=etc|karaf.etc=/opt/sonatype/nexus/etc|g" \
    -e "s|java.util.logging.config.file=etc|java.util.logging.config.file=/opt/sonatype/nexus/etc|g" \
    -e "s|karaf.data=data|karaf.data=${NEXUS_DATA}|g" \
    -e "s|java.io.tmpdir=data/tmp|java.io.tmpdir=${NEXUS_DATA}/tmp|g" \
    -i /opt/sonatype/nexus/bin/nexus.vmoptions

## configure ssl
## add ${karaf.base}/etc/jetty-https.xml to nexus-args
RUN sed "4 c nexus-args=\${karaf.etc}/jetty.xml,\${karaf.etc}/jetty-http.xml,\${karaf.etc}/jetty-requestlog.xml,\${karaf.base}/etc/jetty-https.xml" \
    -i /opt/sonatype/nexus/etc/org.sonatype.nexus.cfg
## set ssl port to 8443
RUN sed "5 a application-port-ssl=8443" \
    -i /opt/sonatype/nexus/etc/org.sonatype.nexus.cfg
    
RUN mkdir -p /opt/sonatype/nexus/etc/ssl

RUN /opt/java/bin/keytool \
    -genkeypair \
    -keystore /opt/sonatype/nexus/etc/ssl/keystore.jks \
    -storepass ${JKS_PASSWORD} \
    -keypass ${JKS_PASSWORD} \
    -alias jetty -keyalg RSA \
    -keysize 2048 \
    -validity 5000 \
    -dname "CN=*.${NEXUS_DOMAIN}, OU=Dev, O=Imix, L=Bogota, ST=Bogota, C=US" \
    -ext "SAN=DNS:${NEXUS_DOMAIN},IP:${NEXUS_IP_ADDRESS}" \
    -ext "BC=ca:true"

RUN sed \
    -e "s|OBF:1v2j1uum1xtv1zej1zer1xtn1uvk1v1v|${JKS_PASSWORD}|g" \
    -i /opt/sonatype/nexus/etc/jetty-https.xml
    

RUN useradd -r -u 200 -m -c "nexus role account" -d ${NEXUS_DATA} -s /bin/false nexus

VOLUME ${NEXUS_DATA}

EXPOSE 8081
EXPOSE 8443
EXPOSE 18443
EXPOSE 18444
USER nexus
WORKDIR /opt/sonatype/nexus

ENV JAVA_MAX_MEM 1200m
ENV JAVA_MIN_MEM 1200m
ENV EXTRA_JAVA_OPTS ""

CMD bin/nexus run