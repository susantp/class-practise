package com.techbizz.westminster.classpractise.demo.productapi;

public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

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

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        discountedPrice = getUnitPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
