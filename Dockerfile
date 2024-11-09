FROM openjdk:17-jdk-alpine

COPY target/bi6-DataMinds-kaddem.jar .

EXPOSE 8070

ENV IMAGE_NAME="ahmed144/ahmedamri-5erpbi6"

ENTRYPOINT ["java", "-jar", "bi6-DataMinds-kaddem.jar"]


