FROM hub.dreams.com/dreams-spring-cloud/openjdk:8-jre-alpine

MAINTAINER dreamstep36 dreamstep36@163.com

ADD target/*.jar eureka.jar

EXPOSE 8761 8762

ENTRYPOINT ["java", "-jar", "/eureka.jar"]
