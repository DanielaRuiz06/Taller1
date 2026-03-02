package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.pojo.Producto;
import co.edu.uptc.model.UnidadMedida;
import co.edu.uptc.util.Utilities;

import java.util.ArrayList;
import java.util.Collections;

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

    public ArrayList<Producto> getList() {
        return (ArrayList<Producto>) managerProduct.getListProduct();
    }

    @Override
    public void createProduct() {
        Producto newProduct = new Producto(consoleView.readString("Digite el nombre del producto"), consoleView.readDouble("Digite el precio del producto"), selectUnidadMedida());
        managerProduct.add(newProduct);
    }

    public void deleteProduct() {
        String description = consoleView.readString("Digite el nombre del producto que desea eliminar");
        if (managerProduct.removeProduct(description)) {
            consoleView.showMessage("El producto " + description + " fue eliminado exitosamente.");
        } else {
            consoleView.showMessage("El producto " + description + " no fue encontrado.");
        }
    }

    public void sortList() {
        managerProduct.getListProduct().sort((o1, o2) -> o1.getDescription().compareToIgnoreCase(o2.getDescription()));
    }

    private UnidadMedida selectUnidadMedida() {
        UnidadMedida unidad;
        do {
            unidad = parseUnidad(consoleView.showEnum(Utilities.ENUM_MESSAGE));
            if (unidad == null)
                consoleView.showError("Opción incorrecta");
        } while (unidad == null);
        return unidad;
    }

    private UnidadMedida parseUnidad(int option) {
        return switch (option) {
            case 1 -> UnidadMedida.TONELADAS;
            case 2 -> UnidadMedida.LIBRA;
            case 3 -> UnidadMedida.GRAMOS;
            case 4 -> UnidadMedida.LITROS;
            case 5 -> UnidadMedida.MILILITROS;
            default -> null;
        };
    }

}
