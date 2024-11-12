FROM openjdk:17-jre-slim
ADD target/kaddem-0.0.1-SNAPSHOT.jar kaddem-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/kaddem-0.0.1-SNAPSHOT.jar"]