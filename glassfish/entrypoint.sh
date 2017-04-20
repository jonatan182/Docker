#!/bin/bash

mkdir -p /var/log/glassfish
mkdir -p /opt/glassfish/domains/domain1/lib/classes/$CONTEXT_ROOT
bin/asadmin multimode --file commands.txt