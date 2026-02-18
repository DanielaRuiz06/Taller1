package co.edu.uptc.model;

public class Producto {
    private String description;
    private double price;
    private UnidadMedida medida;

    public Producto(String description, double price, UnidadMedida medida) {
        this.description = description;
        this.price = price;
        this.medida = medida;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UnidadMedida getMedida() {
        return medida;
    }

    public void setMedida(UnidadMedida medida) {
        this.medida = medida;
    }

    @Override
    public String toString() {
        return
                "[Description='" + description +
                ", Precio=" + price +
                ", Unidad de Medida=" + medida +
                ']';
    }
}
