package co.edu.uptc.interfaces;

import co.edu.uptc.model.utils.Nodo;
import co.edu.uptc.pojo.Producto;

import java.util.ArrayList;
import java.util.List;

public interface ModelInterface {
     void add(Producto p);
    boolean removeProduct(String descriptionProduct);
     ArrayList<Producto> getListProduct();
     void sortList();
}
