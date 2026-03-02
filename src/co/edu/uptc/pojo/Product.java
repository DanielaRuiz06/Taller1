package co.edu.uptc.pojo;

import co.edu.uptc.model.UnitOfMeasure;

public class Product {
    private String description;
    private double price;
    private UnitOfMeasure measurement;

    public Product(String description, double price, UnitOfMeasure measurement) {
        this.description = description;
        this.price = price;
        this.measurement = measurement;
    }

    public String getDescription() {
        return description;
    }

    public UnitOfMeasure getMeasurement() {
        return measurement;
    }

    public void setMeasurement(UnitOfMeasure measurement) {
        this.measurement = measurement;
    }

    @Override
    public String toString() {
        return
                "Descripcion: " + description +
                        ", Precio: " + price +
                        ", Unidad de Medida:" + measurement +
                        '.';
    }
}
