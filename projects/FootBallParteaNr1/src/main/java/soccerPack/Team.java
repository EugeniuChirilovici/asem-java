package soccerPack;

import java.util.ArrayList;
import java.util.List;

public class Team{
    private String nameTeam;
    private List<Player> playerList;

    public Team(String nameTeam) {
        this.nameTeam = nameTeam;
        playerList = new ArrayList<Player>();
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String name) {
        this.nameTeam = name;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void SearchName(String nameInput){
        int simpleNumber =0;
        for ( int i = 0 ; i < playerList.size() ; i++){
            for (int j = 0 ; j < playerList.get(i).getNamePlayer().length() ; j++){
                if( playerList.get(i).getNamePlayer().toLowerCase().contains(nameInput.toLowerCase())){
                    System.out.println(playerList.get(i).getNamePlayer());
                    simpleNumber ++;
                    break;
                }
            }
        }
        if(simpleNumber==0){
            System.out.println("The player was not found");
        }
    }

    public void showPlayers(){
        System.out.println(this.nameTeam);
        for (Player player : playerList) {
            System.out.println("\t"+player.getNamePlayer());
        }
    }
}
