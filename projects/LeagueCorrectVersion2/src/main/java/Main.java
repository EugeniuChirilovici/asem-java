import soccerPack.Game;
import soccerPack.League;
import soccerPack.Player;
import soccerPack.Team;
import utility.GameUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        League league = new League();
        List<Game> games = league.createGame(league.createTeams());

        Game game = games.get(0);

        // add players te game
        Team homeTeam = game.getHomeTeam();
        getPart(1).forEach(homeTeam::addPlayer);
        Team awayTeam = game.getAwayTeam();
        getPart(2).forEach(awayTeam::addPlayer);

        game.playGame();
        GameUtils.addGameGoals(game);

        game.showGoalsStatistics();

        game.showTeams();
    }


    private static List<Player> getPart(int part) {  // 1 || 2
        List<Player> players = listOfPlayers();

        if (part == 1) {
            return players.subList(0, players.size() / 2);
        } else if (part == 2) {
            return players.subList(players.size() / 2, players.size());
        }
        return null;
    }


    private static List<Player> listOfPlayers() {
        List<Player> players = new ArrayList<>();
        listOfNames().forEach(name -> players.add(new Player(name)));
        return players;
    }


    public static List<String> listOfNames() {
        List<String> players = new ArrayList<String>();
        players.add("Radison Blue");
        players.add("Tyron Tapscott");
        players.add("Lynn Lisenby");
        players.add("Johnathan Jesse");
        players.add("Sebastian Salmon");
        players.add("Raul Roberge");
        players.add("Leslie Lanctot");
        players.add("Luther Leiser");
        players.add("Lyman Losh ");
        players.add("Shelby Steigerwald");
        players.add("Brendan Borges ");
        players.add("Sang Swinger");
        players.add("Denny Damico");
        players.add("Daren Dahn");
        players.add("Francisco Flesher");
        players.add("Elwood Echavarria");
        players.add("Toby Theriot ");
        players.add("Aldo Alcantar");
        players.add("Pedro Peck");
        players.add("Mitchell Mclaughin");
        players.add("Troy Trentham");
        players.add("Jacob John");
        return players;
    }
}
