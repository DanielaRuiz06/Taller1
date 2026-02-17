package co.edu.uptc.view;

import java.util.Scanner;

import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;

public class View implements ViewInterface {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void setPresenter(PresenterInterface presenter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPresenter'");
    }

     private String returnMessage(String message){
        String answer = sc.nextLine();
        return answer;

     }
}
