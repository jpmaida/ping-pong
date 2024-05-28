FROM registry.access.redhat.com/ubi8/openjdk-8:latest AS build

COPY pom.xml pom.xml
COPY src src

RUN mvn clean package -DskipTests

RUN ls -la

FROM registry.access.redhat.com/ubi8/openjdk-8:latest AS run
COPY --from=build target/ping-pong.jar ping-pong.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ping-pong.jar"]
