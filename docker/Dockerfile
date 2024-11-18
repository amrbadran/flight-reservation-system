
FROM openjdk:23-jdk-slim

WORKDIR /app

COPY target/airport-ticket-booking.jar /app/airport-ticket-booking.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/airport-ticket-booking.jar"]