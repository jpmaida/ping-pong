package com.redhat.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class PingPong {

    @Value("${MATCH_TIME_IN_MINUTES}") private String matchTimeInMinutes;
    @Value("${PLAYER_1_NAME}") private String player1Name;
    @Value("${PLAYER_2_NAME}") private String player2Name;

    @RequestMapping("/ping")
    @ResponseBody
    public String ping() {
        return "pong";
    }

    @RequestMapping("/pong")
    @ResponseBody
    public String pong() {
        return "ping";
    }

    @RequestMapping("/match")
    @ResponseBody
    public String matchConfigurations() {
        String matchData = "This match will last " + this.matchTimeInMinutes + " minutes.<br/>"
                            + "Player 1 name: " + this.player1Name + "<br/>"
                            + "Player 2 name: " + this.player2Name;
        return matchData;
    }

    @RequestMapping("/referee")
    @ResponseBody
    public String ringTheBell() {
        return "Piiiiiiiiiiii";
    }
}
