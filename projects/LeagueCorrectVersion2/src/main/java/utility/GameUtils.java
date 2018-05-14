package utility;

import soccerPack.*;

import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    public static void addGameGoals(Game game) {
        List<Goal> goals = game.getGoals();

        for (Goal goal : goals) {
            int teamNum = (int) (Math.random() * 2);
            Team team = teamNum == 0 ? game.getHomeTeam() : game.getAwayTeam();

            int playerIndex = (int) (Math.random() * team.getTotalPlayers());
            Player player = team.getPlayer(playerIndex);

            goal.setScoredTeam(team);
            goal.setScoredPlayer(player);
            goal.setTime((Math.random() * 90));
        }
    }

}
