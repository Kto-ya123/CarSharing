FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 3306
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/CarSharing-1.0-SNAPSHOT.jar /app/app.jar
ENV DATABASE_URL=jdbc:mysql://localhost:3306/car
ENV DATABASE_USERNAME=root
ENV DATABASE_PASSWORD=123
ENTRYPOINT ["java","-jar","-Dspring.datasource.url=${DATABASE_URL}","-Dspring.datasource.username=${DATABASE_USERNAME}", "-Dspring.datasource.password=${DATABASE_PASSWORD}","-Djava.security.egd=file:/dev/./urandom","/app/app.jar"]