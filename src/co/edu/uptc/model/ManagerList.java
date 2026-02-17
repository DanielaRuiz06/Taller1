package co.edu.uptc.model;

import co.edu.uptc.interfaces.ModelInterface;

public class ManagerList implements ModelInterface {
    Nodo header = null;

    @Override
    public Nodo createNodo(Producto value) {
        return new Nodo(value);
    }

    @Override
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
    }

    public void showList() {
        Nodo aux = header;
        while (aux != null) {
            System.out.println(aux.value);
            aux = aux.sig;

        }
    }

}
