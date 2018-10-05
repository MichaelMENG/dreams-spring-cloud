#!/usr/bin/env bash

mvn clean package -DskipTests -U

docker build -t hub.dreams.com/dreams-spring-cloud/product:latest .

docker push hub.dreams.com/dreams-spring-cloud/product:latest

