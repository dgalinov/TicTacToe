package controller;

import model.Map;
import model.Player;
import model.Position;

import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);

    private Player player1;
    private Player player2;
    private Map map;

    public Game(Player player1, Player player2, Map map){
        this.player1 = player1;
        this.player2 = player2;
        this.map = map;
    }

    public void setPlayerName(Player player){
        System.out.println("Set player name:");
        String name = sc.nextLine();
        player.setName(name);
    }

    public Position choosePosition(Player player){
        int x;
        int y;
        return null;
    }

    public boolean isValidPosition(Position position){
        if ((position.getX() == 1) || (position.getX() == 2) || (position.getX() == 0) || (position.getY() == 1) || (position.getY() == 2) || (position.getY() == 0)) {

        } else {

        }
    }
}
