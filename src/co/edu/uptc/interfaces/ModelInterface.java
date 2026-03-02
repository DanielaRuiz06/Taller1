package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Product;

import java.util.ArrayList;

public interface ModelInterface {
    void add(Product p);

    boolean removeProduct(String descriptionProduct);

    ArrayList<Product> getListProduct();

    void sortList();
}
