FROM openjdk:17-jdk-alpine
EXPOSE 8070
ADD /target/kaddem.jar kaddem.jar
ENTRYPOINT ["java", "-jar", "kaddem.jar"]
