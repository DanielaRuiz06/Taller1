package co.edu.uptc.interfaces;

import java.util.ArrayList;

import co.edu.uptc.pojo.Product;

public interface ViewInterface {

    void setPresenter(PresenterInterface presenter);

    void start();

    void showMessage(String message);

    String readString(String message);

    void showError(String message);

    double readDouble(String message);

    int showEnum(String message);

    void showList(ArrayList<Product> l);


}
