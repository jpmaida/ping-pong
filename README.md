# hello-world-spring-boot
Spring Boot Hello World repository. This project can be used to presentations, hand-ons or just for studing purposes. Have fun :D


## Project's structure
Web Maven project with Spring Boot engine and API
```
example/
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── redhat
│   │   │           └── resources
│   │   │               ├── PingPong.java -> Ping Pong Game API
│   │   │               └── SpringBootApplicationLauncher.java -> Spring Boot Activator
│   │   ├── resources
│   │   │   └── META-INF
│   │   └── webapp
│   │       ├── WEB-INF
│   │       │   └── beans.xml
│   │       └── resources
│   └── test
│       ├── java
│       └── resources
└── target
```

## Build and Run
To build and install or build and package use the following commands:
```
mvn clean install -DskipTests
```
or
```
mvn clean package -DskipTests
```
The generated JAR will be place inside the `target` folder.
In order to run the application, use:
```
mvn spring-boot:run -DMATCH_TIME_IN_MINUTES=10 -DPLAYER_1_NAME="John Doe" -DPLAYER_2_NAME="Mary Ann"
```

## API Details
A simple API explanation with an endpoints overview.
* PingPong.java - Ping Pong game API. It simulated a Ping Pong match.
	* /ping - It responds "pong", represents a play.
	* /pong - It responds "ping", represents a play.
	* /match - Give match information, it uses external configuration (env-vars).
	* /referee - The referee whistle the bell, game stops.