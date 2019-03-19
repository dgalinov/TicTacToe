package controller;

import model.Map;
import model.Player;
import model.Position;
import model.Token;
import view.MapView;

import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);

    private Player player1;
    private Player player2;
    private Map map;
    private Token t;
    private int cont = 0;
    private MapView mapView = new MapView();;

    public void play() {
        choosePosition();
    }

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void setPlayerName(Player player){
        System.out.println("Set player name:");
        String name = sc.nextLine();
        player.setName(name);
    }

    public void choosePosition(){
        Position position = new Position();
        int X = 0;
        int Y = 0;
        do {
            System.out.println("Set Horizontal Position:");
            X = Integer.parseInt(sc.nextLine());
            position.setX(X);
            System.out.println("Set Vertical Position:");
            Y = Integer.parseInt(sc.nextLine());
            position.setY(Y);
        } while (!isValidPosition(position));

        map.setPosTable(X, Y, playerRound());

        mapView.printMap(map);
    }

    public Token playerRound(){
        if (cont == 0){
            cont ++;
            return Token.X;
        } else {
            cont --;
            return Token.O;
        }
    }

    public boolean isValidPosition(Position position){
        //if ((position.getX() == 1) || (position.getX() == 2) || (position.getX() == 0) || (position.getY() == 1) || (position.getY() == 2) || (position.getY() == 0)) {
            if (map.isEmpty() == true) {
                return true;
            } else {
                return false;
            }
        /*} else {
            return false;
        }*/
    }

}
