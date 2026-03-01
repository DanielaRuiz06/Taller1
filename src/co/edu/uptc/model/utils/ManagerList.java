package co.edu.uptc.model.utils;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.pojo.Producto;

public class ManagerList implements ModelInterface {
    Nodo header = null;
    int size=0;
//    Collections co =new Collection<Nodo>();


    public Nodo createNodo(Producto value) {
        return new Nodo(value);
    }


    public Nodo returnLastNodo() {
        Nodo last = header;
        while (last.sig != null) {
            last = last.sig;
        }
        return last;
    }

    public void addEnd(Producto value) {
        Nodo aux = createNodo(value);
        if (header == null) {
            header = aux;

        } else {
            Nodo ultimo = returnLastNodo();
            ultimo.sig = aux;
        }
        size++;
    }


    public int size(){
        return  size;
    }

    public Producto get(int i){
        Producto p =null;

        // TODO: BUSCAR PRODUCTO
        return p;
    }



    public boolean eliminarProducto(String value) {
        boolean isDelete = false;
        while (header != null && value.equalsIgnoreCase(header.value.getDescription())) {
            isDelete = true;
            header = header.sig;
        }
        Nodo aux = header;
        while (aux != null && aux.sig != null) {
            if (value.equalsIgnoreCase(aux.sig.value.getDescription())) {
                isDelete = true;
                aux.sig = aux.sig.sig;
            } else {
                aux = aux.sig;
            }

        }
        return isDelete;
    }

    public String organizarLista() {
        String mss = "";
        Nodo actualNodo = header;
        if (header != null) {
            boolean cambio;
            do {
                cambio = false;
                actualNodo = header;
                while (actualNodo.sig != null) {
                    if (actualNodo.value.getDescription().compareToIgnoreCase(actualNodo.sig.value.getDescription()) > 0) {
                        Producto aux = actualNodo.value;
                        actualNodo.value = actualNodo.sig.value;
                        actualNodo.sig.value = aux;

                        cambio = true;

                    } else {
                        actualNodo = actualNodo.sig;
                    }

                }
            } while (cambio);
        } else {


        }
        return mss;

    }

}
