package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.model.utils.ManagerList;
import co.edu.uptc.model.utils.Nodo;
import co.edu.uptc.pojo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ManagerProduct implements ModelInterface {
    ManagerList listProduct = new ManagerList();

    public ArrayList<Producto> getListProduct() {
        ArrayList<Producto> aux = new ArrayList<>();
        for (int i = 0; i < listProduct.size(); i++) {
            aux.add(listProduct.get(i));
        }
        return aux;
    }

    public void sortList() {
        ArrayList<Producto> products = getListProduct();
        products.sort((o1, o2) -> o1.getDescription().compareToIgnoreCase(o2.getDescription()));
        updateNodos(products);

    }

    private void updateNodos(ArrayList<Producto> list) {
        listProduct.deleteNodos();
        for (Producto producto : list) {
            listProduct.addEnd(producto);
        }

    }

    public boolean removeProduct(String descriptionProduct) {
        return listProduct.remove(descriptionProduct);
    }

    @Override
    public void add(Producto p) {
        listProduct.addEnd(p);
    }

}
