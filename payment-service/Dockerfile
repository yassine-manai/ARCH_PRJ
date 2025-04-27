# Use the official OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . .

# Build the application
RUN ./mvnw package -DskipTests

# Expose the application port (change according to the service)
EXPOSE 6030

# Run the JAR file
CMD ["java", "-jar", "target/*.jar"]
