FROM openjdk:11
ARG JAR_FILE=build/libs/*1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/app.jar"]