package controller;

import model.Map;
import model.Player;
import model.Position;
import model.Token;
import view.MapView;

import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    private Map map = new Map();
    private int cont = 0;
    private MapView mapView = new MapView();

    public void play(){
        choosePosition();
    }

    public Game(){
        map.initialTable();
    }

    public void setPlayerName(Player player){
        System.out.print("Set player name:");
        String name = sc.nextLine();
        player.setName(name);
    }

    public void choosePosition(){
        Position position = new Position();
        int X = 0;
        int Y = 0;

        do {
            try {
                System.out.println("Introduce a position of X & Y [0-1-2]");
                System.out.print("Set X:");
                X = Integer.parseInt(sc.nextLine());
                System.out.print("Set Y:");
                Y = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Value input X or Y not valid, pls try again");
            }
            position.setX(X);
            position.setY(Y);
        } while (!isValidPosition(X, Y));

        map.setPosTable(X, Y, changeTokenPerRound());

        mapView.printMap(map);
    }

    public Token changeTokenPerRound(){
        if (cont == 0){
            cont ++;
            return Token.X;
        } else {
            cont --;
            return Token.O;
        }
    }

    public Token getPlayerRound() {
        if (cont == 0) {
            return Token.X;
        } else {
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

    public boolean gameOver(){
        if (hasWinner()) {
            System.out.println("You WIN " + getPlayerRound() + " !");
            return true;
        }
        if (tableIsFull()) {
            System.out.println("Tie");
            return true;
        }
        return false;
    }

    public boolean tableIsFull() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (map.getTable()[i][j] == Token.H){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner(){
        if (verticalLine(getPlayerRound())) {
            return true;
        }
        if (horizontalLine(getPlayerRound())) {
            return true;
        }
        if (diagonalLineLeftToRight(getPlayerRound())) {
            return true;
        }
        if (diagonalLineRightToLeft(getPlayerRound())) {
            return true;
        }
        return false;
    }

    public boolean verticalLine(Token t){
        outer:for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!map.getTable()[i][j].equals(t)) continue outer;
            }
            return true;
        }
        return false;
    }

    public boolean horizontalLine(Token t){
        outer:for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!map.getTable()[j][i].equals(t)) continue outer;
            }
            return true;
        }
        return false;
    }

    public boolean diagonalLineLeftToRight(Token t){
        if ((map.getTable()[0][0].equals(t)) && (map.getTable()[1][1].equals(t)) && (map.getTable()[2][2].equals(t))){
            return true;
        }
        return false;
    }

    public boolean diagonalLineRightToLeft(Token t){
        if ((map.getTable()[0][2].equals(t)) && (map.getTable()[1][1].equals(t)) && (map.getTable()[2][0].equals(t))){
            return true;
        }
        return false;
    }
}
