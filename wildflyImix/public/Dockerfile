# Use imix/wildfly (centos6.6 ,java7 and widlfly9) image as the base
FROM imix/wildfly
MAINTAINER http://www.imix.com.co

USER wildfly

# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]



