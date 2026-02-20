package co.edu.uptc.view;

import java.util.Scanner;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.UnidadMedida;

public class View implements ViewInterface {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void setPresenter(PresenterInterface presenter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPresenter'");
    }


     public String returnMessage(String message){
         System.out.println(message);
        String answer = sc.nextLine();
        return answer;

    }

    public int menuPrincipal(String[] message) {
        int answer=0;
        for (String string : message) {
            System.out.println(string);

        }
        boolean aux = true;
        while (aux) {
            System.out.println(" opcion: ");
            try {
                answer = sc.nextInt();
                sc.nextLine();
                aux = false;
                // sc.nextLine();
            } catch (Exception e) {
                System.out.println(" solo numeros");;
                sc.nextLine();
            }
        }
        return answer;

    }

    public void showMessage(String message) {
        System.out.println(message);
    }
    public String showEnum(String message){
        showMessage(message);
        int i =1;
        for (UnidadMedida u : UnidadMedida.values()){
            System.out.println(i+". " + u);
            i++;
        }
         message = sc.next();
        return message;
     }

     public double readDouble (String message){
         double answer=0;
         System.out.println(message);
         boolean aux = true;
         while (aux) {
             try {
                 answer = sc.nextDouble();
                 sc.nextLine();
                 aux = false;
                 // sc.nextLine();
             } catch (Exception e) {
                 System.out.println(" solo numeros");;
                 sc.nextLine();
             }
         }
         return answer;

     }
     public void showErrorMessage(String message){
        System.err.println(message);
     }

}
