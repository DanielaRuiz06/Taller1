package co.edu.uptc.model.utils;

import java.util.ArrayList;

import co.edu.uptc.pojo.Product;

public class ManagerList {
    Node header = null;
    int size = 0;
    ArrayList<Product> listDiscontinuedProducts = new ArrayList<>();

    public Node createNode(Product value) {
        return new Node(value);
    }

    private Node returnLastNode() {
        Node last = header;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    public void addEnd(Product value) {
        Node aux = createNode(value);
        if (header == null) {
            header = aux;
        } else {
            Node last = returnLastNode();
            last.next = aux;
        }
        size++;
    }

    public int size() {
        return this.size;
    }

    public Product get(int i) {
        return searchNode(i).value;
    }

    private Node searchNode(int i) {
        Node aux = null;
        if (this.size > i || this.size != 0) {
            for (int count = 0; count != i + 1; count++) {
                aux = (count == 0) ? header : aux.next;
            }
        }
        return aux;
    }

    public boolean remove(String description) {
        return removeNode(header, header, description);
    }

    private boolean removeNode(Node aux, Node tmp, String value) {
        if (aux != null) {
            removeNode(aux.next, aux, value);
            if (aux.value.getDescription().contains(value)) {
                listOfDiscontinuedProducts(aux.value);
                if (tmp == aux) header = aux.next;
                else tmp.next = aux.next;
                size--;

            }
        }
        return true;
    }

    private void listOfDiscontinuedProducts(Product producto) {

        listDiscontinuedProducts.add(producto);

    }

    public void emptyList() {
        listDiscontinuedProducts.clear();
    }

    public void deleteNodes() {
        header = null;
        this.size = 0;

    }

    public ArrayList<Product> getListOfDiscontinuedProducts() {
        return listDiscontinuedProducts;
    }
}
