package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.model.UnitOfMeasure;
import co.edu.uptc.util.Utilities;

import java.util.ArrayList;

public class Administrador implements PresenterInterface {
    private ViewInterface consoleView;
    private ModelInterface managerProduct;

    @Override
    public void setView(ViewInterface view) {
        this.consoleView = view;
    }

    @Override
    public void setModel(ModelInterface model) {
        this.managerProduct = model;
    }

    public ArrayList<Product> getList() {
        return (ArrayList<Product>) managerProduct.getListProduct();
    }

    @Override
    public void createProduct() {
        Product newProduct = new Product(consoleView.readString("Digite el nombre del producto"),
                consoleView.readDouble("Digite el precio del producto"), selectUnidadMedida());
        managerProduct.add(newProduct);
    }

    public void deleteProduct() {
        String description = consoleView.readString("Digite la descripción o parte de esta, de el o los productos que desea eliminar");
        if (managerProduct.removeProduct(description)) {
            consoleView.showMessage("Los siguientes productos fueron eliminados exitosamente.");
            consoleView.showList((managerProduct.getListOfDiscontinuedProducts()));
            managerProduct.emptyListOfDiscontinuedProducts();

        } else {
            consoleView.showMessage("Ningun producto coincide con la busqueda de " + description);
        }
    }

    public void sortList() {
        managerProduct.sortList();

    }

    private UnitOfMeasure selectUnidadMedida() {
        UnitOfMeasure unidad;
        do {
            unidad = parseUnidad(consoleView.showEnum(Utilities.ENUM_MESSAGE));
            if (unidad == null)
                consoleView.showError("Opción incorrecta");
        } while (unidad == null);
        return unidad;
    }

    private UnitOfMeasure parseUnidad(int option) {
        return switch (option) {
            case 1 -> UnitOfMeasure.TONELADAS;
            case 2 -> UnitOfMeasure.LIBRA;
            case 3 -> UnitOfMeasure.GRAMOS;
            case 4 -> UnitOfMeasure.LITROS;
            case 5 -> UnitOfMeasure.MILILITROS;
            default -> null;
        };
    }

}
