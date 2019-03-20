package controller;

import model.Map;
import model.Player;
import model.Position;
import model.Token;
import view.MapView;

import java.util.Scanner;

import static model.Token.X;

public class Game {
    Scanner sc = new Scanner(System.in);

    private Player player1;
    private Player player2;
    private Map map;
    private Token t;
    private int cont = 0;
    private MapView mapView = new MapView();;

    public void play(){
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
        } while (!isValidPosition(X, Y));

        map.setPosTable(X, Y, playerRound());

        mapView.printMap(map);
    }

    public Token playerRound(){
        if (cont == 0){
            cont ++;
            return X;
        } else {
            cont --;
            return Token.O;
        }
    }

    public boolean isValidPosition(int X, int Y){
        boolean valid = false;
        if ((X < 0) || (X > 2) || (Y < 0) || (Y > 2)){
            valid = false;
        } else if (map.isEmpty(X, Y)){
            valid = true;
        }
        return  valid;
    }


    public boolean hasWin(){
        if(playerRound() == X){

        } else if (playerRound() == Token.O) {

        }
        return false;
    }

    public boolean verticalLine(){
        boolean hasLine = false;
        for(int i = 0; i < 3; i++) {
            hasLine = true;
            for(int j = 0; j < 3; j++) {
                Position position = new Position(i, j);
                if (playerRound() == X) {
                    if (map.getTable()[i][j] == Token.X){

                    }
                }
            }
            if (hasLine = false) {
                return hasLine = true;
            }
        }
        return hasLine;
    }

    public boolean horizontalLine(){

    }

    public boolean diagonalLineLeftToRight() {

    }

    public boolean diagonalLineRightToLeft() {

    }
}
