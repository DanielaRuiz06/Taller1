package co.edu.uptc.view;

import java.util.Scanner;

import co.edu.uptc.util.Utilities;

public class Menu {
    private Scanner keyboard = new Scanner(System.in);
     private int opt = 0;
     private ConsoleView consoleView= new ConsoleView();

    public void show() {
        String[] message = Utilities.MAIN_MENU;
        for (String string : message) {
            System.out.println(string);
        }

    }



    public int start() {
        do {
            show();
            opt = consoleView.readInt();

        } while (opt < 1 || opt > 5);
        return opt;
    }

}
