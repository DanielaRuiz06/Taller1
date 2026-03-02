package co.edu.uptc.model.utils;

import co.edu.uptc.pojo.Product;

public class ManagerList {
    Node header = null;
    int size = 0;

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
        return removeHeader(description) || removeNode(description);
    }

    private boolean removeNode(String value) {
        boolean isDelete = false;
        for (Node aux = header; aux != null && aux.next != null; aux = aux.next) {
            if (value.equalsIgnoreCase(aux.next.value.getDescription())) {
                isDelete = true;
                aux.next = aux.next.next;
                size--;
        return isDelete;
    }

    private boolean removeHeader(String value) {
        boolean isDelete = false;
        while (header != null && value.equalsIgnoreCase(header.value.getDescription())) {
            isDelete = true;
            header = header.next;
            size--;
        }
        return isDelete;
    }

    public void deleteNodes() {
        header = null;
        this.size = 0;
        

    }

}
