FROM openjdk:8
COPY target/Prescription-0.0.1-SNAPSHOT.jar Prescription-0.0.1-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "Prescription-0.0.1-SNAPSHOT.jar"]