package com.redhat;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("")
public class PingPong {

    @ConfigProperty(name = "MATCH_TIME_IN_MINUTES", defaultValue = "")
    private String matchTimeInMinutes;
    @ConfigProperty(name = "PLAYER_1_NAME", defaultValue = "")
    private String player1Name;
    @ConfigProperty(name = "PLAYER_2_NAME", defaultValue = "")
    private String player2Name;

    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String ping() {
        return "pong";
    }

    @Path("/pong")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String pong() {
        return "ping";
    }

    @Path("/match")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String matchConfigurations() {
        String matchData = "This match will last " + this.matchTimeInMinutes + " minutes.<br/>"
                            + "Player 1 name: " + this.player1Name + "<br/>"
                            + "Player 2 name: " + this.player2Name;
        return matchData;
    }

    @Path("/referee")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String ringTheBell() {
        return "Piiiiiiiiiiii";
    }
}
