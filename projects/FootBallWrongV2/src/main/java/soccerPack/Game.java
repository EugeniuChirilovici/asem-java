package soccerPack;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Team homeTeam;
    private Team awayTeam;

    public Game(){}

    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public List<Integer> playGame(int number){
        List<Integer> goals = new ArrayList<Integer>();
        for (int n=0;n<number;n++){
            goals.add((int)(Math.random()*number));
        }
        return goals;
    }
}
