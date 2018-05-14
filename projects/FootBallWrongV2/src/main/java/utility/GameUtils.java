package utility;
import soccerPack.*;

import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    public ArrayList<Goal> addGameGoals() {
        ArrayList<Goal> goals = new ArrayList<Goal>();
        goals.add(new Goal(new Team(new League().createTeam().get(1).getNameTeam()), new Player("Penelope Fabe"), 10.40));
        goals.add(new Goal(new Team(new League().createTeam().get(1).getNameTeam()), new Player("Pipio Francesco"), 17.26));
        goals.add(new Goal(new Team(new League().createTeam().get(0).getNameTeam()), new Player("Ruslan Ruslanaci"), 37.54));
        goals.add(new Goal(new Team(new League().createTeam().get(0).getNameTeam()), new Player("Robert Daniel"), 43.43));
        goals.add(new Goal(new Team(new League().createTeam().get(1).getNameTeam()), new Player("Patric Spanchbobovich"), 77.31));
        goals.add(new Goal(new Team(new League().createTeam().get(1).getNameTeam()), new Player("Peter Mari"), 85.02));
        return goals;
    }

    public int playGame() {
        List<Integer> list = new Game().playGame(7);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
}
