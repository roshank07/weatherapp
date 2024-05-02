# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

# The application's jar file
ARG JAR_FILE=target/your-artifactId-version.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]