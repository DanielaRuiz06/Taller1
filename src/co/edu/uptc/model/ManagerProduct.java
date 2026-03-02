package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.model.utils.ManagerList;
import co.edu.uptc.model.utils.Nodo;
import co.edu.uptc.pojo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ManagerProduct  implements ModelInterface {
    ManagerList listProduct = new ManagerList();


    public ArrayList<Producto> getListProduct() {
    ArrayList<Producto> aux = new ArrayList<>();
        for (int i = 0; i < listProduct.size(); i++) {
            aux.add(listProduct.get(i));
        }
        return aux;
    }

    public boolean removeProduct(String descriptionProduct){
        return listProduct.remove(descriptionProduct);
    }

    @Override
    public void add(Producto p) {
        listProduct.addEnd(p);
    }

}
