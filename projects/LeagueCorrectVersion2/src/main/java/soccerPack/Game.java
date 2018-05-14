package soccerPack;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private List<Goal> goals = new ArrayList<Goal>();


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

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public void playGame(int number) {
        List<Goal> goals = new ArrayList<Goal>();
        for (int i = 0; i < number; i++) goals.add(new Goal());
        setGoals(goals);
    }

    public void playGame() {
        playGame(6);
    }

    public void showTeams(){
        System.out.println("\n\tThe teams that played:");
        for (Team team: new League().createTeams()) {
            System.out.println(team.toString());
        }
    }

    public void showGoalsStatistics() {
        System.out.println("\n\n\tThe statistics of the goals scored:");
        for (Goal goal : getGoals()) {
            System.out.println(goal.toString());
        }
    }
}
