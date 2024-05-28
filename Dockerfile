FROM registry.access.redhat.com/ubi8/openjdk-8:latest AS build

WORKDIR /home/jboss
USER root
COPY pom.xml pom.xml
COPY src src
RUN chown -R jboss:jboss pom.xml src/
USER jboss
RUN mvn clean package -DskipTests && ls -la target/

FROM registry.access.redhat.com/ubi8/openjdk-8:latest AS run

WORKDIR /home/jboss
COPY --from=build /home/jboss/target/ping-pong.jar ping-pong.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ping-pong.jar"]