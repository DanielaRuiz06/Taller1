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

    private void showListProduct() {
        vista.showMessage( Utilities.MESSAGE_SHOW_LIST );
        consoleView.showListProduct(managerProduct.getListProduct());
    }

    @Override
    public void createProduct() {
        Producto newProduct = new Producto(consoleView.readString("Digite el nombre del producto"), consoleView.readDouble("Digite el precio del producto"), selectUnidadMedida());
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

    private UnidadMedida selectUnidadMedida() {
            boolean isCorrect = true;
            UnidadMedida optionSelected = null;
        do {
            String option = vista.showEnum(Utilities.ENUM_MESSAGE);
            isCorrect = true;
            switch (option) {
                case "1" -> optionSelected = UnidadMedida.TONELADAS;
                case "2" -> optionSelected = UnidadMedida.LIBRA;
                case "3" -> optionSelected = UnidadMedida.GRAMOS;
                case "4" -> optionSelected = UnidadMedida.LITROS;
                case "5" -> optionSelected = UnidadMedida.MILILITROS;
                default -> {
                    vista.showMessage("Opción incorrecta");
                    isCorrect = false;
                }
            }
        } while (!isCorrect);

        return optionSelected;
    }


}
