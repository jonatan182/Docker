# Use imix/wildfly (centos6.6 ,java7 and widlfly9) image as the base
FROM imix/wildfly
MAINTAINER http://www.imix.com.co

RUN curl -o /opt/wildfly/standalone/deployments/PublicServices-1.5.0.war -L http://10.44.55.35:8081/nexus/service/local/artifact/maven/content?r=releases&g=com.imix&a=PublicServices&type=war&v=1.5.0

# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]



