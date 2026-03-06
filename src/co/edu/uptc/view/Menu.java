package co.edu.uptc.view;


import co.edu.uptc.util.Utilities;


public class Menu {

    private int opt = 0;
    private ConsoleView consoleView = new ConsoleView();

    public void show() {
        String[] message = Utilities.MAIN_MENU;
        System.out.println();
        System.out.println("  --------------------------------------------------------------  ");
        for (String string : message) {
            System.out.println(string);
        }
        System.out.println("  --------------------------------------------------------------  ");


    }


    public int start() {
        do {
            show();
            opt = consoleView.readInt();

        } while (opt < 1 || opt > 5);
        return opt;
    }

}
