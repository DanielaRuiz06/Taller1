package co.edu.uptc.interfaces;

import co.edu.uptc.model.utils.Nodo;
import co.edu.uptc.pojo.Producto;

import java.util.List;

public interface ModelInterface {
    public void add(Producto p);
    public List<Producto> getListProduct();
}
