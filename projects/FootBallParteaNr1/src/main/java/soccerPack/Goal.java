package soccerPack;

public class Goal {
    private Team scoredTeam;
    private Player scoredPlayer;
    private double time;

    public Goal(Team scoredTeam, Player scoredPlayer, double time) {
        this.scoredTeam = scoredTeam;
        this.scoredPlayer = scoredPlayer;
        this.time = time;
    }

    @Override
    public String toString() {
        return time+"\t "+scoredPlayer.getNamePlayer()+"\t "+scoredTeam.getNameTeam();
    }

    public Team getScoredTeam() {
        return scoredTeam;
    }

    public void setScoredTeam(Team scoredTeam) {
        this.scoredTeam = scoredTeam;
    }

    public Player getScoredPlayer() {
        return scoredPlayer;
    }

    public void setScoredPlayer(Player scoredPlayer) {
        this.scoredPlayer = scoredPlayer;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
