package co.edu.uptc.presenter;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.interfaces.PresenterInterface;
import co.edu.uptc.interfaces.ViewInterface;
import co.edu.uptc.model.ManagerList;
import co.edu.uptc.model.Producto;
import co.edu.uptc.model.UnidadMedida;
import co.edu.uptc.util.Utilities;
import co.edu.uptc.view.View;

public class Administrador implements PresenterInterface {
    private View vista;
    private ManagerList managerList;

    public Administrador() {
        this.vista = new View();
        this.managerList = new ManagerList();
    }

    @Override
    public void setView(ViewInterface view) {

    }

    @Override
    public void setModel(ModelInterface model) {

    }

    @Override
    public Producto createProduct(String description, double price, UnidadMedida medida) throws Exception {
        Producto nuevoProducto = null;
        if (price != 0 && medida != null) {
            nuevoProducto = new Producto(description, price, medida);
        } else {
            throw new Exception("Error al crear el producto");

        }

        return nuevoProducto;
    }

    @Override
    public void deleteProduct(String description)  {
        if(!description.equalsIgnoreCase("")){
            if ( managerList.eliminarProducto(description)){
                vista.showMessage("El producto "+ description+" fue eliminado exitosamente.");
            }else {
                vista.showMessage("El producto "+ description+" no fue encontrado.");
            }
        }else {
            vista.showMessage("Por favor, ingrese una descripcion del producto valida.");
        }
    }


    private void init() {
        try {
            vista.showMessage(Utilities.MENSAJE_BIENVENIDA);
            int option = Integer.parseInt(vista.returnMessage(Utilities.MENU_PRINCIPAL));
            while (option != 5) {
                switch (option) {
                    case 1:
                        createProduct(vista.returnMessage("Digite el nombre del producto"),
                                castToDouble(), selectUnidadMedida());

                        break;
                    case 2:
                        vista.showMessage("Los productos agregados en la lista son: \n" + managerList.showList2());
//                        managerList.showList();
                        break;

                    case 3:
                        break;
                    case 4:
                        deleteProduct(vista.returnMessage(Utilities.MENSAJE_ELIMINAR_PRODUCTO));
                        break;

                    default:
                        break;
                }

            }
            vista.showMessage(Utilities.MENSAJE_FINAL);

        } catch (Exception e) {
            throw new NumberFormatException("Digite un número");

        }

    }

    private UnidadMedida selectUnidadMedida() {
        UnidadMedida optionSelected = null;
        int p = 1;
        do {
        String option = vista.showEnum(Utilities.MENSAJE_ENUM);
            switch (option) {
                case "0":
                    p = 0;
                    break;
                case "1":
                    optionSelected = UnidadMedida.TONELADAS;
                    p = 0;
                    break;
                case "2":
                    optionSelected = UnidadMedida.LIBRA;
                    p = 0;
                    break;

                case "3":
                    optionSelected = UnidadMedida.GRAMOS;
                    p = 0;
                    break;

                case "4":
                    optionSelected = UnidadMedida.LITROS;
                    p = 0;
                    break;
                case "5":
                    optionSelected = UnidadMedida.MILILITROS;
                    p = 0;
                    break;

                default:
                    vista.showMessage("Opción incorrecta");
                    break;
            }

        } while (p != 0);

        return optionSelected;
    }

    private double castToDouble() {
        String numb = vista.returnMessage("Digite el precio:");
        double price = 0;
        try {
            price = Double.parseDouble(numb);

        } catch (Exception e) {
            vista.showMessage("Dato inválido");
        }

        return price;

    }
}
