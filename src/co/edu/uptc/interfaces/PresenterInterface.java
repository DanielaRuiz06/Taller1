package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Producto;

import java.util.ArrayList;

public interface PresenterInterface {
    public void setView (ViewInterface view);
    public void setModel (ModelInterface model);
    public void createProduct ();
    public void deleteProduct ();
    ArrayList<Producto> getList();
    void sortList();

}
