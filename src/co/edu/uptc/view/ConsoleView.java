package co.edu.uptc.view;

public class ConsoleView {


    public void start(){
        Menu menu = new Menu();
        while (true) {
            int opt = menu.start();
            fillActions(opt);

        }
          
    }
    public void fillActions(int option){
     switch (option) {
    case 1 -> addProduct();
    case 2 -> showList();
    case 3 -> showOrderedList();
    case 4 -> deleteProduct();
    case 5 -> programExit();
    default -> System.out.println("Opción inválida");
};
    }

    public void addProduct(){};
    private void showList(){};
    private void showOrderedList(){};
    private void deleteProduct(){};
    private void programExit(){};
}
