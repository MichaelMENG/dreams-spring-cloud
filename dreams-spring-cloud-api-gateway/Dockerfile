FROM hub.dreams.com/dreams-spring-cloud/openjdk:8-jre-alpine

MAINTAINER dreamstep36 dreamstep36@163.com

ADD target/*.jar api-gateway.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/api-gateway.jar"]
