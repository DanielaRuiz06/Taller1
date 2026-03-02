package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.utils.ManagerList;
import co.edu.uptc.pojo.Producto;
import co.edu.uptc.model.ManagerProduct;
import co.edu.uptc.model.UnidadMedida;
import co.edu.uptc.util.Utilities;
import co.edu.uptc.view.ConsoleView;
import co.edu.uptc.view.View;

public class Administrador implements PresenterInterface {
    private View vista;
    private ManagerList managerList;
    private ConsoleView consoleView;
    private ManagerProduct managerProduct;

    public Administrador() {
        this.vista = new View();
        this.managerList = new ManagerList();
        this.consoleView = new ConsoleView();
        this.managerProduct = new ManagerProduct();
    }

    @Override
    public void setView(ViewInterface view) {

    }

    @Override
    public void setModel(ModelInterface model) {

    }

    public void init() {
        vista.showMessage(Utilities.MENSAJE_BIENVENIDA);
        int option = 0;
        do {
            try {
                option = vista.menuPrincipal(Utilities.MENU_PRINCIPAL);

                switch (option) {
                    case 1 -> createProduct(vista.returnMessage("Digite el nombre del producto"),
                            vista.readDouble("Digite el precio del producto"), selectUnidadMedida());
                    case 2 ->
                        // vista.showMessage("Los productos agregados en la lista son: \n" +
                        // managerList.showList());
                        managerList.showList();
                    case 3 ->
                        vista.showMessage(managerList.organizarLista() + "La lista es: " + managerList.showList());
                    case 4 -> deleteProduct(vista.returnMessage(Utilities.MENSAJE_ELIMINAR));
                    default ->vista.showMessage("Opcion Invalida!!");
                }
            } catch (Exception e) {
                vista.showErrorMessage(e.getMessage());
            }
        } while (option != 5);
        vista.showMessage(Utilities.MENSAJE_FINAL);
    }

    @Override
    public void createProduct(String description, double price, UnidadMedida medida) throws Exception {

        Producto nuevoProducto = null;
        if (price != 0 && medida != null && !description.isEmpty()) {
            nuevoProducto = new Producto(description, price, medida);
            managerList.addEnd(nuevoProducto);
            System.out.println("si se creo el producto");
        } else {
            throw new Exception("Error al crear el producto");

        }

    }

    public void createProductP() {
        Producto newProduct = new Producto(consoleView.readString("Digite el nombre del producto"), consoleView.readDouble("Digite el precio del producto"), selectUnidadMedida());
        managerList.addEnd(newProduct);
    }
    public void deleteProduct(){
        String description = consoleView.readString("Digite el nombre del producto que desea eliminar");
        if (managerProduct.removeProduct(description)) {
                vista.showMessage("El producto " + description + " fue eliminado exitosamente.");
            } else {
                vista.showMessage("El producto " + description + " no fue encontrado.");
            }
    }

    @Override
    public void deleteProduct(String description) {
        if (!description.equalsIgnoreCase("")) {
            if (managerList.eliminarProducto(description)) {
                vista.showMessage("El producto " + description + " fue eliminado exitosamente.");
            } else {
                vista.showMessage("El producto " + description + " no fue encontrado.");
            }
        } else {
            vista.showMessage("Por favor, ingrese una descripcion del producto valida.");
        }
    }

    private UnidadMedida selectUnidadMedida() {
        UnidadMedida optionSelected = null;
        boolean isCorrect = true;
        do {
            String option = vista.showEnum(Utilities.MENSAJE_ENUM);
            isCorrect = true;
            switch (option) {
                case "0":

                    break;
                case "1":
                    optionSelected = UnidadMedida.TONELADAS;

                    break;
                case "2":
                    optionSelected = UnidadMedida.LIBRA;

                    break;

                case "3":
                    optionSelected = UnidadMedida.GRAMOS;

                    break;

                case "4":
                    optionSelected = UnidadMedida.LITROS;

                    break;
                case "5":
                    optionSelected = UnidadMedida.MILILITROS;

                    break;

                default:
                    vista.showMessage("Opción incorrecta");
                    isCorrect = false;

                    break;
            }

        } while (!isCorrect);

        return optionSelected;
    }

}
