FROM openjdk:8-jdk-alpine
MAINTAINER github.com/Rahulbudhiraja25
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/invoice-generator.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
