package co.edu.uptc.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.pojo.Producto;
import co.edu.uptc.presenter.Administrador;
import co.edu.uptc.util.Utilities;

public class ConsoleView implements ViewInterface {
    private Scanner keyboard = new Scanner(System.in);
    private Administrador admin = new Administrador();
    private PresenterInterface presenter;

    public void start() {
        Menu menu = new Menu();
        while (true) {
            int opt = menu.start();
            fillActions(opt);
        }

    }

    public void fillActions(int option) {
        switch (option) {
            case 1 -> addProduct();
            case 2 -> showList();
            case 3 -> showOrderedList();
            case 4 -> deleteProduct();
            case 5 -> programExit();
            default -> System.out.println("Opción inválida");
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
        admin.createProduct();
         
    };


    private void showOrderedList() {
       admin.sortList();
       showList();
    };

    private void deleteProduct() {
        admin.deleteProduct();
    };

    private void programExit() {
        showMessage(Utilities.FINAL_MESSAGE);
        System.exit(0);
    };

    public String readString(String message) {
        String description = "";
        do {
            System.out.println(message);
            description = keyboard.nextLine();
            if (!description.isEmpty()) return description;    
            showError("Este campo no puede estar vacío");
        } while (true);
    }

    public void showError(String message) {
        System.err.println("*******************************************");
        System.err.println(message);
        System.err.println("*******************************************");
    }

 public double readDouble(String message) {
    while (true) {
        System.out.println(message);
        try {
            return Double.parseDouble(keyboard.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Solo números 😁");
        }
    }
}

    @Override
    public void setPresenter(PresenterInterface presenter) {this.presenter= presenter;}
}
