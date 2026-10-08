package com.techbizz.westminster.classpractise.demo.productapi;

public class Product {
    private int id;
    private String name;
    private int qty;
    private boolean inStock;
    private double unitPrice;

//    public Product() {}
    public Product(int id, String name, int qty, boolean inStock, double unitPrice){
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.inStock = inStock;
        this.unitPrice = unitPrice;
    }
    public double calculateTotal() {
        return this.qty * this.unitPrice;
    }

    public int getId(){ return this.id; }
    public String getName() { return this.name; }
    public int getQty() { return this.qty;}
    public boolean getInStock() { return this.inStock; }
    public double getUnitPrice() { return this.unitPrice; }
}
