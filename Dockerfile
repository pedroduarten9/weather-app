#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /weather-app/src
COPY pom.xml /weather-app
RUN mvn -f /weather-app/pom.xml clean install

#
# Package stage
#
FROM openjdk:11-jre-slim
ARG JAR_FILE=/weather-app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
