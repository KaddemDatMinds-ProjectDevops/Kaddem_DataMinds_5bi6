FROM openjdk:17-jre-ahmed

COPY target/bi6-DataMinds-kaddem.jar .
EXPOSE 8089
ENV IMAGE_NAME="ahmedamri-bi6-khaddem"
ENTRYPOINT ["java", "-jar", "bi6-DataMinds-kaddem.jar"]
