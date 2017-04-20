# Use latest Fedora image as the base
FROM imix/java7
MAINTAINER http://www.imix.com.co

RUN yum -y install tar

# Set the WILDFLY_VERSION env variable
ENV WILDFLY_VERSION 9.0.1.Final

# Create the wildfly user and group
RUN groupadd -r wildfly -g 1000 && useradd -u 1000 -r -g wildfly -d /opt/wildfly -s /sbin/nologin -c "WildFly user" wildfly

# Create directory to extract tar file to
RUN mkdir /opt/wildfly-$WILDFLY_VERSION

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
RUN cd /opt && curl http://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz | tar zx \
    && chown -R wildfly:wildfly /opt/wildfly-$WILDFLY_VERSION \
	&& rm -f wildfly-$WILDFLY_VERSION.tar.gz

# Make sure the distribution is available from a well-known place
RUN ln -s /opt/wildfly-$WILDFLY_VERSION /opt/wildfly && chown -R wildfly:wildfly /opt/wildfly

# Set local time to Bogota
RUN cp /usr/share/zoneinfo/America/Bogota /etc/localtime

# Run everything below as the wildfly user
USER wildfly

# Set the JBOSS_HOME env variable
ENV JBOSS_HOME /opt/wildfly

RUN /opt/wildfly/bin/add-user.sh admin 12345678 --silent

COPY sql $JBOSS_HOME/modules/system/layers/base/com/sql

COPY execute.sh /home/execute.sh
COPY config.cli /home/config.cli

RUN sh /home/execute.sh

USER root
RUN rm /home/config.cli
USER wildfly

RUN rm -rf /opt/wildfly/standalone/configuration/standalone_xml_history/current

ONBUILD COPY imix $JBOSS_HOME/modules/system/layers/base/com/imix
ONBUILD COPY config.cli /home/config.cli
ONBUILD RUN sh /home/execute.sh

ONBUILD RUN rm -rf /opt/wildfly/standalone/configuration/standalone_xml_history/current

# Expose the ports we're interested in
EXPOSE 8080 9990

# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
CMD ["/bin/echo"]



