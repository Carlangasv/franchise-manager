FROM amazoncorretto:21

WORKDIR /app
COPY build/libs/manager-1.jar app.jar
EXPOSE 8080
# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
