package co.edu.uptc.model;

public class ManagerList {
    Nodo header = null;

    private Nodo createNodo(Producto value) {
        return new Nodo(value);
    }

    private Nodo returnlastNodo() {
        Nodo last = header;
        while (last.sig != null) {
            last = last.sig;
        }
        return last;
    }

    public void addEnd(Producto value) {
        Nodo aux = new Nodo(value);
        if (header == null) {
            header = aux;

        } else {
            Nodo ultimo = returnlastNodo();
            ultimo.sig = aux;
        }
    }

    public void showList() {
        Nodo aux = header;
        while (aux != null) {
            System.out.println(header.value);
            aux = aux.sig;

        }
    }
    
}
