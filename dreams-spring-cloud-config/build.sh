#!/usr/bin/env bash

mvn clean package -DskipTests -U

docker build -t hub.dreams.com/dreams-spring-cloud/config:latest .

docker push hub.dreams.com/dreams-spring-cloud/config:latest

