package co.edu.uptc.interfaces;

import co.edu.uptc.model.Nodo;
import co.edu.uptc.model.Producto;

public interface ModelInterface {
    public Nodo createNodo(Producto value);
    public Nodo returnLastNodo();
    public void addEnd(Producto value);
    public void showList();

}
