FROM jenkins:2.19.3

ENV JENKINS_OPTS --httpPort=8888

COPY plugins.txt /usr/share/jenkins/ref/
RUN /usr/local/bin/plugins.sh /usr/share/jenkins/ref/plugins.txt