package co.edu.uptc.model.utils;

import co.edu.uptc.interfaces.ModelInterface;
import co.edu.uptc.pojo.Producto;

public class ManagerList  {
    Nodo header = null;
    int size=0;

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
        return  this.size;
    }

    public Producto get(int i){
        return searchNode(i).value;
    }

    public Nodo searchNode(int i){
        Nodo aux=null;
        if(this.size>i|| this.size!=-0){
            for (int count = 0; count!=i+1 ; count++){
                aux= (count==0) ? header : aux.sig;
            }
        }
        return aux;
    }

    public boolean remove(String description) {
        return removeHeader(description) || removeNodo(description);
    }

    private boolean removeNodo(String value){
        boolean isDelete = false;
        for (Nodo aux = header; aux != null && aux.sig != null; aux = aux.sig) {
            if (value.equalsIgnoreCase(aux.sig.value.getDescription())) {
                isDelete = true;
                aux.sig = aux.sig.sig;
                size--;
            }
        }
        return isDelete;
    }

    private boolean removeHeader(String value){
        boolean isDelete = false;
        while (header != null && value.equalsIgnoreCase(header.value.getDescription())) {
            isDelete = true;
            header = header.sig;
            size--;
        }
        return isDelete;
    }

    

    public void deleteNodos(){
        header = null;
        this.size = 0;
        

    }

}
