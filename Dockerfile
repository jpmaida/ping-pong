FROM registry.access.redhat.com/ubi8/openjdk-17:1.21-1.1744797574 AS build

WORKDIR /home/jboss
USER root
COPY pom.xml pom.xml
COPY src src
RUN chown -R jboss:jboss pom.xml src/
USER jboss
RUN mvn clean package -DskipTests

FROM registry.access.redhat.com/ubi8/openjdk-17:1.21-1.1744797574 AS run

WORKDIR /home/jboss
COPY --from=build /home/jboss/target/quarkus-app quarkus-app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quarkus-app/quarkus-run.jar"]