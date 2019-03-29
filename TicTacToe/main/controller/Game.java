package controller;

import model.Map;
import model.Player;
import model.Position;
import model.Token;
import view.MapView;

import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);
    private Map map = new Map();
    private int cont = 0;
    private MapView mapView = new MapView();

    public void play(){
        if(!gameOver()) {
            choosePosition();
        }

    }

    public Game(){
        map.initialTable();
    }

    public void setPlayerName(Player player) {
        String name;
        do {
            do {
                System.out.print("Set player name:");
                name = sc.nextLine();
            } while (name.isEmpty());
        }while(!playerNameValidation(name));

        player.setName(name);
    }

    private void choosePosition(){
        Position position = new Position();
        int X = -1;
        int Y = -1;

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

        } while (!isValidPosition(X, Y));

        position.setX(X);
        position.setY(Y);

        map.setPositionTable(X, Y, changeTokenPerRound());


        mapView.printMap(map);
    }

    private Token changeTokenPerRound(){
        if (cont == 0){
            cont ++;
            return Token.X;
        } else {
            cont --;
            return Token.O;
        }
    }

    private Token getPlayerRound() {
        if (cont == 0) {
            return Token.X;
        } else {
            return Token.O;
        }
    }

    private boolean isValidPosition(int X, int Y){
        if ((X < 0) || (X > 2) || (Y < 0) || (Y > 2)){
            return false;
        } else if (map.positionIsEmpty(X, Y)){
            return true;
        }
        return  false;
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

    private boolean tableIsFull() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (map.getTable()[i][j] == Token.H){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasWinner(){
        if (verticalLine(getPlayerRound())) {
            return true;
        }
        if (horizontalLine(getPlayerRound())) {
            return true;
        }
        if (diagonalLineLeftToRight(getPlayerRound())) {
            return true;
        }
        return diagonalLineRightToLeft(getPlayerRound());
    }

    private boolean verticalLine(Token t){
        outer:for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!map.getTable()[i][j].equals(t)) continue outer;
            }
            return true;
        }
        return false;
    }

    private boolean horizontalLine(Token t){
        outer:for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!map.getTable()[j][i].equals(t)) continue outer;
            }
            return true;
        }
        return false;
    }

    private boolean diagonalLineLeftToRight(Token t){
        return (map.getTable()[0][0].equals(t)) && (map.getTable()[1][1].equals(t)) && (map.getTable()[2][2].equals(t));
    }

    private boolean diagonalLineRightToLeft(Token t){
        return (map.getTable()[0][2].equals(t)) && (map.getTable()[1][1].equals(t)) && (map.getTable()[2][0].equals(t));
    }

    public static boolean playerNameValidation(String name){
        boolean valid = name.matches("(?i)(^[a-z]+)[a-z .,-]((?! .,-)$){1,25}$");
        return valid;
    }
}
