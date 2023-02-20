#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/Crop-Go-API-0.0.1-SNAPSHOT.jar Crop-Go-API.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","Crop-Go-API.jar"]