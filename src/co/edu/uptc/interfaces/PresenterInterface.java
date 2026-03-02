package co.edu.uptc.interfaces;

import co.edu.uptc.model.UnidadMedida;

public interface PresenterInterface {
    public void setView (ViewInterface view);
    public void setModel (ModelInterface model);

    public void createProduct () throws Exception;
    public void deleteProduct ();
}
