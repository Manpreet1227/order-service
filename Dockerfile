FROM eclipse-temurin:17.0.12_7-jre-jammy
WORKDIR /opt
COPY target/order-0.0.1-SNAPSHOT.jar /opt/app.jar
ENTRYPOINT ["java", "-jar", "/opt/app.jar"]
