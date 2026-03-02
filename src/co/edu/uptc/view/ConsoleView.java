package co.edu.uptc.view;

import java.util.Scanner;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.UnitOfMeasure;
import co.edu.uptc.util.Utilities;

public class ConsoleView implements ViewInterface {
    private Scanner keyboard = new Scanner(System.in);
    private PresenterInterface admin;

    public void start() {
        int opt = -1;
        do {
            Menu menu = new Menu();
            opt = menu.start();
            fillActions(opt);

       } while (opt!=5);
    }

    public void fillActions(int option) {
        switch (option) {
            case 1 -> addProduct();
            case 2 -> showList();
            case 3 -> showOrderedList();
            case 4 -> deleteProduct();
            case 5 -> programExit();
        }
        ;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    private void showList() {
        showMessage( Utilities.MESSAGE_SHOW_LIST);
        admin.getList().forEach(System.out::println);
    }

    public void addProduct() {
        try {
            admin.createProduct();
        } catch (Exception e) {
           showError( e.getMessage());
        }


    };

    private void showOrderedList() {
        admin.sortList();
        showList();
    };

    private void deleteProduct() {
        try {
                    admin.deleteProduct();
        } catch (Exception e) {
          showError(e.getMessage());
        }
    };

    private void programExit() {
        showMessage(Utilities.FINAL_MESSAGE);
        System.exit(0);
    };

   private void validarIntentos(int intentos) {
    if (intentos ==0)
        throw new IllegalStateException("Demasiados intentos inválidos, ERROR EN EL PROCESO");
   
}

 public String readString(String message) {
    int intentos = 3;
    while (true) {
        System.out.println(message);
        String input = keyboard.nextLine();
        if (!input.isBlank()) return input;
        showError("Este campo no puede estar vacío, le quedan: "+--intentos + " intentos");
        validarIntentos(intentos);
    }
}


    public void showError(String message) {
        System.err.println("*******************************************");
        System.err.println(message);
        System.err.println("*******************************************");
    }
/*
    public double readDouble(String message) {
        int intento = 3;
        while (true) {
            System.out.println(message);
            try {return Double.parseDouble(keyboard.nextLine()); }
            catch (NumberFormatException e) {
                System.err.println("Ingrese un dato válido, le quedan: "+--intento+" intentos");
                 validarIntentos(intento);
            }
        }
    } */
   public double readDouble(String message) {
    for (int i = 3; i > 0; i--) {
        System.out.println(message);
        try { return Double.parseDouble(keyboard.nextLine()); }
        catch (NumberFormatException e) {
            showError("Dato inválido. Intentos restantes: " + (i - 1));
        }
    }
    throw new IllegalStateException("Demasiados intentos inválidos");
}

    public int showEnum(String message) {
        showMessage(message);
        int i =1;
        for (UnitOfMeasure u : UnitOfMeasure.values()){
            System.out.println(i+". " + u);
            i++;
        }
        return readInt();
    }

    public int readInt() {
        int opt = -1;
        try {
            System.out.println("Escriba una opcion: ");
            String aux = keyboard.nextLine();
            opt = Integer.parseInt(aux);
        } catch (NumberFormatException e) {
            System.err.println("Ingrese un dato válido, por favor");
        }
        return opt;
    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.admin = presenter;
    }
}
