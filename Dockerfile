FROM openjdk:17-jdk-alpine
COPY target/5SE3-G2-khaddem.jar .
EXPOSE 8070
ENV IMAGE_NAME="ahmedamri-5erpbi6"

ENTRYPOINT ["java", "-jar", "5SE3-G2-khaddem.jar"]

