package view;

import controller.Game;
import model.Player;

import java.util.Scanner;

public class Menu {

    public Menu()

    {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        Game game;
        Player player1 = new Player();
        Player player2 = new Player();
        do {
            try {
                System.out.println("Choose an option[1-2]\n" +
                        "1.New Game\n" +
                        "2.Exit");
                option = Integer.parseInt(sc.nextLine());
                if (option == 2 || option == 1) {
                    switch (option) {
                        case 1:
                            game = new Game();
                            game.setPlayerName(player1);
                            game.setPlayerName(player2);
                            do {
                                game.play();
                            } while (!game.gameOver());
                            break;
                        case 2:
                            System.out.println("Exiting the program...");
                            break;
                    }
                } else {
                    System.out.println("Value is more or lower than the range of the options.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Value introduced is not valid, please try again.");
            }
        } while (option != 2);
    }
}
