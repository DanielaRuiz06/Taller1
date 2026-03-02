package co.edu.uptc.interfaces;

import co.edu.uptc.pojo.Product;

import java.util.ArrayList;

public interface PresenterInterface {
    void setView(ViewInterface view);

    void setModel(ModelInterface model);

    void createProduct();

    void deleteProduct();

    ArrayList<Product> getList();

    void sortList();

}
