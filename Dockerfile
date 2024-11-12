FROM openjdk:17-jdk-alpine
EXPOSE 8089
ADD target/kaddem-0.0.1-20241112.144615-1.jar kaddem.jar
ENTRYPOINT ["java", "-jar", "/kaddem.jar"]
