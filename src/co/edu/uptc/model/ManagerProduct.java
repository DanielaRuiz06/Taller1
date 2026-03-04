package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.model.utils.ManagerList;
import co.edu.uptc.pojo.Product;

import java.util.ArrayList;

public class ManagerProduct implements ModelInterface {
    ManagerList listProduct = new ManagerList();

    public ArrayList<Product> getListProduct() {
        ArrayList<Product> aux = new ArrayList<>();
        for (int i = 0; i < listProduct.size(); i++) {
            aux.add(listProduct.get(i));
        }
        return aux;
    }

    public ArrayList <Product> sortList() {
        ArrayList<Product> products = getListProduct();
        products.sort((o1, o2) -> o1.getDescription().compareToIgnoreCase(o2.getDescription()));
        return products;
    }


    public boolean removeProduct(String descriptionProduct) {
        return listProduct.remove(descriptionProduct);
 }
 public ArrayList<Product> getListOfDiscontinuedProducts(){
    return listProduct.getListOfDiscontinuedProducts();
    
 }
 public void emptyListOfDiscontinuedProducts(){
    listProduct.emptyList();
 }

    @Override
    public void add(Product product) {
        listProduct.addEnd(product);
    }

}
