package soccerPack;

public class Team{
    protected String nameTeam;

    public Team(String nameTeam) {
        this.nameTeam = nameTeam;
    }
    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String name) {
        this.nameTeam = name;
    }

    @Override
    public String toString() {
        return "{" + nameTeam + '}';
    }
}
