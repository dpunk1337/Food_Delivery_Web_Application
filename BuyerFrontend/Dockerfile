FROM openjdk:8-jdk-alpine
# FROM amazoncorretto:8-alpine-jdk
MAINTAINER deepank.puri
COPY target/BuyerFrontend-0.0.1-SNAPSHOT.war buyer-frontend-0.0.1.war
ENTRYPOINT ["java","-jar","/buyer-frontend-0.0.1.war"]