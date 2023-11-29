FROM openjdk:21-jdk-slim

VOLUME /tmp
COPY /build/libs/feed-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
# Set the working directory
#WORKDIR /app
# Copy the JAR file to the container
#COPY target/feed.jar app.jar
# Expose the port that your Spring Boot application listens on (default is 8080)
#EXPOSE 8080
# Define the command to run your application
#CMD ["java", "-jar", "app.jar"]

#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#COPY target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

