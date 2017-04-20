FROM centos:6.6

COPY jdk-6u45-linux-x64-rpm.bin /home/jdk-6u45-linux-x64-rpm.bin

RUN chmod +x /home/jdk-6u45-linux-x64-rpm.bin
RUN /home/jdk-6u45-linux-x64-rpm.bin

ENV JAVA_HOME="/usr/java/jdk1.6.0_45"

CMD ["/bin/bash"]