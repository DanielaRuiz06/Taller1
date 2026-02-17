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
        String answer = sc.nextLine();
        return answer;

    }

    public String returnMessage(String[] message) {
        for (String string : message) {
            System.out.println(string + "\n");

        }

        String answer = sc.nextLine();
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
}
