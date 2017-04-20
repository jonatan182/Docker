# Use centos 6.6 image as the base
FROM imix/java7

# Create folder to store switches
RUN mkdir /opt/movilred

ENV SWITCH_HOME	/opt/movilred

# Add user adminstall
RUN useradd -r -M -d $SWITCH_HOME adminstall && \
    chown adminstall:adminstall /opt/movilred -R && \
	chown adminstall:adminstall /var/log -R

# Set local time to Bogota
RUN cp /usr/share/zoneinfo/America/Bogota /etc/localtime

COPY entrypoint.sh /entrypoint.sh
RUN chmod -R 777 /entrypoint.sh
	
# Create folders for switches
RUN mkdir -p /opt/movilred/switch_mysql/jar/
RUN mkdir -p /var/log/movilred/switch/

# Create folders for registers
RUN mkdir -p /opt/movilred/reg/jar/
RUN mkdir -p /var/log/movilred/reg/

# Folder for keys
RUN mkdir -p /opt/movilred/switch
COPY keys /opt/movilred/switch/keys

RUN chmod -R 777 /opt/movilred
RUN chmod -R 777 /var/log/movilred

#USER adminstall 

EXPOSE 50000

ENTRYPOINT ["/entrypoint.sh"]