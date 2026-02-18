package co.edu.uptc.interfaces;

import co.edu.uptc.model.Producto;
import co.edu.uptc.model.UnidadMedida;

public interface PresenterInterface {
    public void setView (ViewInterface view);
    public void setModel (ModelInterface model);
    public Producto createProduct (String description, double price, UnidadMedida medida ) throws Exception;
    public void deleteProduct (String description);
}
