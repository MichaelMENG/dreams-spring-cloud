FROM hub.dreams.com/dreams-spring-cloud/openjdk:8-jre-alpine

MAINTAINER dreamstep36 dreamstep36@163.com

ADD server/target/*.jar product.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/product.jar"]
