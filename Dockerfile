FROM openjdk:8-jdk-alpine
COPY target/MySpringBootApp-1.0-SNAPSHOT.jar /app/
CMD java -jar /app/MySpringBootApp-1.0-SNAPSHOT.jar