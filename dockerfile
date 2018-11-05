FROM openjdk:8u131-jdk-alpine

MAINTAINER Carl Silber "carl.silber74@gmail.com"

EXPOSE 8080

WORKDIR /usr/local/bin/

COPY ./target/pm_backend-0.0.1-SNAPSHOT.jar pm_backend.jar

CMD ["java", "-Dspring.profiles.active=dev-h2", "-jar", "pm_backend.jar"]