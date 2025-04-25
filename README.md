# hello-world-spring-boot
Spring Boot Hello World repository. This project can be used to presentations, hand-ons or just for studing purposes. Have fun :D

## Repo's structure
```
hello-world-spring-boot
├── README.md ~> ReadMe file
├── example ~> Maven project
├── ocp ~> Configuration files to deloy the application on Openshift
│   ├── configmap.yaml
│   └── oc-commands.md
└── useful-commands.md ~> Some useful commands
```

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
### Build
To build and install or build and package use the following commands:
```
mvn clean install -DskipTests
```
or
```
mvn clean package -DskipTests
```
The generated JAR will be place inside the `target` folder.
### Run
In order to run the application locally, use:
```
mvn spring-boot:run -DMATCH_TIME_IN_MINUTES=10 -DPLAYER_1_NAME="John Doe" -DPLAYER_2_NAME="Mary Ann"
```
In case of using Docker, use the following commands:
```
docker build -f Dockerfile -t ping-pong:latest .
docker run -p 8080:8080 -e MATCH_TIME_IN_MINUTES=<your-time> -e PLAYER_1_NAME="<name-player-1>" -e PLAYER_2_NAME="<name-player-2>" ping-pong:latest
```
If Openshift is your thing see the `oc-commands.md` file inside the `ocp` directory.

### Environment Variables
* MATCH_TIME_IN_MINUTES ~> How many time, in minutes, one match takes.
* PLAYER_1_NAME ~> Player 1 name
* PLAYER_2_NAME ~> Player 2 name

## API Details
A simple API explanation with an endpoints overview.
* PingPong.java - Ping Pong game API. It simulated a Ping Pong match.
	* /ping - It responds "pong", represents a play.
	* /pong - It responds "ping", represents a play.
	* /match - Give match information, it uses external configuration (env-vars).
	* /referee - The referee whistle the bell, game stops.
