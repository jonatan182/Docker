# Use imix/wildfly (centos6.6 ,java7 and widlfly9) image as the base
FROM imix/wildfly
MAINTAINER http://www.imix.com.co

# Run everything below as the wildfly user
USER wildfly

# Set the JBOSS_HOME env variable
ENV JBOSS_HOME /opt/wildfly

COPY imix $JBOSS_HOME/modules/system/layers/base/com/imix

COPY config.cli /home

RUN sh /home/execute.sh

RUN rm -rf /opt/wildfly/standalone/configuration/standalone_xml_history/current

# Expose the ports we're interested in
EXPOSE 8080 9990

# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]



