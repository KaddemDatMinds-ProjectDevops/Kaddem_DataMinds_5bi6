FROM openjdk:17-jdk-alpine
EXPOSE 8070
ADD /target/5ErpBi6-khaddem.jar kaddem.jar
ENTRYPOINT ["java", "-jar", "kaddem.jar"]
