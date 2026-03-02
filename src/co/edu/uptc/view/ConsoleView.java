package co.edu.uptc.view;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.uptc.pojo.Producto;
import co.edu.uptc.presenter.Administrador;

public class ConsoleView {
    private Scanner keyboard = new Scanner(System.in);
    private Administrador admin = new Administrador();

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

    private void showList() {
    }

    public void addProduct() {
        admin.createProduct();
         
    };

    public void showListProduct (ArrayList<Producto> list){
        list.forEach(System.out::println);
    }

    private void showOrderedList() {
    };

    private void deleteProduct() {
    };

    private void programExit() {
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
}
