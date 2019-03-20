package view;

import controller.Game;
import model.Player;

import java.util.Scanner;

public class Menu {

    public Menu()

    {
        Scanner sc = new Scanner(System.in);
        int option;
        Game game;
        Player player1 = new Player();
        Player player2 = new Player();
        do {
            System.out.println("Choose an option[1-2]\n" +
                    "1.New Game\n" +
                    "2.Exit");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    game = new Game(player1, player2);
                    game.setPlayerName(player1);
                    game.setPlayerName(player2);
                    do {
                        game.play();
                    }while (true);
                case 2:
                    System.out.println("Exiting the program...");
                    break;
            }
        } while (option != 2);
    }
}
