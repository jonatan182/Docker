FROM node:boron

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app


#add bitbucket key

#ADD id_rsa ~/.ssh/id_rsa
#RUN chmod 700 ~/.ssh/id_rsa
#RUN  echo "    IdentityFile ~/.ssh/id_rsa" >> /etc/ssh/ssh_config


#RUN ssh-agent /bin/bash
#RUN ssh-add ~/.ssh/id_rsa

ADD id_rsa /tmp/id_rsa
RUN \
  # add SSH key
  chmod 600 /tmp/id_rsa && \
  eval $(ssh-agent) && \
  echo "StrictHostKeyChecking no" >> /etc/ssh/ssh_config && \
  ssh-add /tmp/id_rsa && \
  git clone git@bitbucket.org:imixconsulting/node-microservices.git /usr/src/app/

# Install app dependencies
WORKDIR /usr/src/app
RUN npm install

# Bundle app source
#COPY . /usr/src/app


ENV node_port 8080
EXPOSE 8080
CMD [ "npm", "start" ]