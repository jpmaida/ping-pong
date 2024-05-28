FROM registry.access.redhat.com/ubi8/openjdk-8:latest
ADD target/ping-pong.jar ping-pong.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ping-pong.jar"]
