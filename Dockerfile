FROM openjdk:18-ea-11-jdk-alpine3.15
VOLUME /tmp
EXPOSE 8080
ADD target/*.jar app.jar
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar"]
