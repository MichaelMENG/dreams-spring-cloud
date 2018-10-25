#!/usr/bin/env bash

docker stop dreamspace-jenkins
docker rm dreamspace-jenkins

docker run -d \
  --name dreamspace-jenkins \
  --hostname jenkins
  -u root
  -p 80:8080 \
  -p 50000:50000 \
  --env JAVA_OPTS="-Djava.util.logging.config.file=/var/jenkins_home/log.properties" \
  -v /home/vagrant/jenkins/jenkins_home:/var/jenkins_home \
  jenkins/jenkins:lts