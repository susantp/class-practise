package com.techbizz.westminster.classpractise.demo.productapi;

public class DigitalProduct extends Product implements Discountable {
    private String downloadUrl;
    private double fileSizeMB;
    private double discountedPrice;

    public DigitalProduct(int id, String name, int qty, boolean inStock, double unitPrice, String downloadUrl, double fileSizeMB) {
        super(id, name, qty, inStock, unitPrice);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }
    public static DigitalProduct from(int id, CreateProductRequest productRequest) {
        return new DigitalProduct(
                id,
                productRequest.name(),
                productRequest.qty(),
                productRequest.inStock(),
                productRequest.unitPrice(),
                "http://xsdfa.com/file/3434",
                23.33
        );
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

    @Override
    public void applyDiscount(double rate) {
        discountedPrice = getUnitPrice() * (1 - rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
