FROM openjdk:16.0.2
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]