package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.Producto;
import co.edu.uptc.model.UnidadMedida;

public class Administrador implements PresenterInterface {
    @Override
    public void setView(ViewInterface view) {

    }

    @Override
    public void setModel(ModelInterface model) {

    }

    @Override
    public Producto createProduct(String description, double price, UnidadMedida medida) {
      Producto nuevoProducto = new Producto(description, price, medida);
      return nuevoProducto;
    }
    
}
