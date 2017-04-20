# Use centos image as the base
FROM centos:6.6

MAINTAINER http://www.imix.com.co/

RUN curl -LO 'http://download.oracle.com/otn-pub/java/jdk/7u80-b15/jdk-7u80-linux-x64.rpm' \
    -H 'Cookie: oraclelicense=accept-securebackup-cookie' \
    && rpm -i jdk-7u80-linux-x64.rpm \
	&& rm -f jdk-7u80-linux-x64.rpm

CMD ["/bin/bash"]