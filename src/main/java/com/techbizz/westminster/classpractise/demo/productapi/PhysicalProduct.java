package com.techbizz.westminster.classpractise.demo.productapi;

public class PhysicalProduct extends Product {
    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {
    }

    public PhysicalProduct(int id, String name, int qty, boolean inStock, double unitPrice, double weightKg, String dimensions) {
        super(id, name, qty, inStock, unitPrice);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return this.weightKg;
    }
    public String getDimensions() {
        return this.dimensions;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName()
                + " | " + weightKg + "kg";
    }
}
