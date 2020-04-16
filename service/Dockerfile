# latest oracle openjdk is the basis
FROM openjdk:oracle
# copy jar file into container image under app directory
ARG JAR_FILE=service/target/*.jar
COPY ${JAR_FILE} service.jar
# expose server port accept connections
EXPOSE 9090:9090
# start application
CMD ["java", "-jar", "service.jar"]