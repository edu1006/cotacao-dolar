# latest oracle openjdk is the basis
FROM openjdk:oracle
# copy jar file into container image under app directory
ARG JAR_FILE=cateno-gateway/target/*.jar
COPY ${JAR_FILE} gateway-service.jar
# expose server port accept connections
EXPOSE 8080
# start application
CMD ["java", "-jar", "gateway-service.jar"]