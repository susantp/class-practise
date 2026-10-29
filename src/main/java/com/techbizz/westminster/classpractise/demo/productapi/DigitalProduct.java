package com.techbizz.westminster.classpractise.demo.productapi;

public class DigitalProduct extends Product {
    private String downloadUrl;
    private double fileSizeMB;

    public DigitalProduct(int id, String name, int qty, boolean inStock, double unitPrice, String downloadUrl, double fileSizeMB) {
        super(id, name, qty, inStock, unitPrice);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }
    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public double getFileSizeMB() {
        return this.fileSizeMB;
    }

    @Override
    public String getSummary() {
        return "Digital: " + getName()
                + " | " + getDownloadUrl();
    }
}
