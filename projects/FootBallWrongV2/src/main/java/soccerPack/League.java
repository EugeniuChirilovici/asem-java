package soccerPack;

import utility.*;
import java.util.ArrayList;
import java.util.Collections;

public class League {

    public ArrayList<Team> createTeam(){
        ArrayList<Team> teams = new ArrayList<Team>();
        teams.add(new Team("Real Madrid"));
        teams.add(new Team("Paris Saint Germain"));
        return teams;
    }

    public ArrayList<Game> createGame(ArrayList<Team> teams){
        ArrayList<Game> game = new ArrayList<Game>();
        game.add(new Game(new Team(teams.get(0).getNameTeam()),new Team(teams.get(1).getNameTeam())));
        return game;
    }

    public static void main(String[] args) {
//        for(Game g: new League().createGame(new League().createTeam())){
//            System.out.println(g.getAwayTeam() + " " + g.getHomeTeam() );
//        }

        System.out.println("AwayTeam" + new League().createGame(new League().createTeam()).get(0).getAwayTeam() +
                "   HomeTeam" + new League().createGame(new League().createTeam()).get(0).getHomeTeam());

        GameUtils goals = new GameUtils();
        ArrayList<Goal> list = goals.addGameGoals();
        Collections.shuffle(list);
        int number = new GameUtils().playGame();
        for(int i = 0; i<number;i++){
            System.out.println(list.get(i));
        }


//        for (Goal g : new GameUtils().addGameGoals())
////            System.out.println(g.getScoredPlayerName() + " " + g.getScoredTeamName() + " " + g.getTime());
//            System.out.println(g);

        System.out.println("The number of goals is \t" + number);
    }
}
