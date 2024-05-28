FROM registry.access.redhat.com/ubi8/openjdk-8:latest AS build

COPY pom.xml .
COPY src .

RUN mvn clean package -DskipTests

FROM registry.access.redhat.com/ubi8/openjdk-8:latest AS run
COPY --from=build target/ping-pong.jar ping-pong.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ping-pong.jar"]
