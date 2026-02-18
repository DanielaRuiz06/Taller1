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
    public String showList2() {
        Nodo aux = header;
        String mensaje = "";
        int i= 1;
        while (aux != null) {
            mensaje += "Producto "+i +":"+ aux.value.toString() + "\n";
            aux = aux.sig;
            i++;
        }
        return mensaje;
    }

    public boolean eliminarProducto(String value){
        boolean isDelete=false;
        while (header !=null&& value.equalsIgnoreCase(header.value.getDescription())) {
                isDelete=true;
            header = header.sig;
        }
        Nodo aux = header;
        while (aux != null && aux.sig!= null) {
            if (value.equalsIgnoreCase(aux.sig.value.getDescription())){
                    isDelete=true;
                aux.sig= aux.sig.sig;
            } else {
                aux = aux.sig;
            }

        }
        return isDelete;
    }

    public String organizarLista() {
        String mss = "";
        
        
        Nodo actualNodo = header;
        if (header != null){
            boolean cambio;
            do {
                 cambio = false;
                
            
            while (actualNodo.sig != null) {
                if (actualNodo.value.getDescription().compareToIgnoreCase(actualNodo.sig.value.getDescription()) > 0) {
                    String aux = actualNodo.value.getDescription();
                    actualNodo.value.setDescription(actualNodo.sig.value.getDescription()); 
                    actualNodo.sig.value.setDescription(aux);
                    cambio = true;
                    
                }else{
                    actualNodo = actualNodo.sig;
                }
             
            }
 } while (cambio);
        }else{

            mss = "No hay productos aún";
        }
        return mss;

    }

}
