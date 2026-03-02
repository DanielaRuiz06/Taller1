package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.ManagerProduct;
import co.edu.uptc.pojo.Producto;
import co.edu.uptc.model.UnidadMedida;
import co.edu.uptc.util.Utilities;
import co.edu.uptc.view.ConsoleView;
import co.edu.uptc.view.View;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Administrador implements PresenterInterface {
    private View vista;
    private ConsoleView consoleView;

    private ManagerProduct managerProduct;

    public Administrador() {
        this.vista = new View();
        this.consoleView = new ConsoleView();
        this.managerProduct = new ManagerProduct();
    }

    @Override
    public void setView(ViewInterface view) {

    }

    @Override
    public void setModel(ModelInterface model) {

    }

    public ArrayList<Producto> getList(){
        return (ArrayList<Producto>) managerProduct.getListProduct();
    }

    @Override
    public void createProduct() {
        Producto newProduct = new Producto(consoleView.readString("Digite el nombre del producto"), consoleView.readDouble("Digite el precio del producto"),selectUnidadMedida());
        managerProduct.add(newProduct);
    }
    public void deleteProduct(){
        String description = consoleView.readString("Digite el nombre del producto que desea eliminar");
        if (managerProduct.removeProduct(description)) {
            vista.showMessage("El producto " + description + " fue eliminado exitosamente.");
        } else {
            vista.showMessage("El producto " + description + " no fue encontrado.");
        }
    }

    public void sortList(){
        Collections.sort(managerProduct.getListProduct(),(o1, o2) -> o1.getDescription().compareToIgnoreCase(o2.getDescription()));
    }

    private UnidadMedida selectUnidadMedida() {
        UnidadMedida unidad;
        do {
            unidad = parseUnidad(vista.showEnum(Utilities.ENUM_MESSAGE));
            if (unidad == null)
                consoleView.showError("Opción incorrecta");
        } while (unidad == null);
        return unidad;
    }

    private UnidadMedida parseUnidad(String option) {
        return switch (option) {
            case "1" -> UnidadMedida.TONELADAS;
            case "2" -> UnidadMedida.LIBRA;
            case "3" -> UnidadMedida.GRAMOS;
            case "4" -> UnidadMedida.LITROS;
            case "5" -> UnidadMedida.MILILITROS;
            default -> null;
        };
    }

}
