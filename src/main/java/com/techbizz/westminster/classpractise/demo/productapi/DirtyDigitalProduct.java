package com.techbizz.westminster.classpractise.demo.productapi;

public class DirtyDigitalProduct {
    private int id;
    private String name;
    private int qty;
    private boolean inStock;
    private double unitPrice;
    private String downloadUrl;
    private double fileSizeMB;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getQty() {
        return this.qty;
    }

    public boolean isInStock() {
        return this.inStock;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public double getFileSizeMB() {
        return this.fileSizeMB;
    }
}
