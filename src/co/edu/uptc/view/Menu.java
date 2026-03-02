package co.edu.uptc.view;

import java.util.Scanner;

import co.edu.uptc.util.Utilities;

public class Menu {
    private Scanner keyboard = new Scanner(System.in);
     private int opt = 0;

    public void show() {
        String[] message = Utilities.MENU_PRINCIPAL;
        for (String string : message) {
            System.out.println(string);

        }

    }

    private void readInt() {

        try {
            System.out.println(" Escriba una opcion: ");
            String aux = keyboard.nextLine();
            opt = Integer.parseInt(aux);
        } catch (NumberFormatException e) {
            System.err.println("Solo numeros 😁");
        }

    }

    public int start() {
        do {
            show();
            readInt();

        } while (opt < 1 || opt > 5);
        return opt;
    }

}
