package view;

import java.util.Scanner;

public class Menu {

    public Menu()

    {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("Choose an option[1-2]\n" +
                    "1.New Game\n" +
                    "2.Exit");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:


                    break;
                case 2:
                    System.out.println("Byebye");
                    break;
            }
        } while (option != 2);
    }
}
