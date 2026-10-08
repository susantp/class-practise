package com.techbizz.westminster.classpractise.demo.productapi;

public class Product {
    private int id;
    private String name;
    private int qty;
    private boolean inStock;
    private double unitPrice;

    private static int instanceCount = 0;

    public Product(int id, String name, int qty, boolean inStock, double unitPrice) {
        instanceCount++;
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.inStock = inStock;
        this.unitPrice = unitPrice;
    }

    public double calculateTotal() {
        return this.qty * this.unitPrice;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getQty() {
        return this.qty;
    }

    public boolean getInStock() {
        return this.inStock;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}
