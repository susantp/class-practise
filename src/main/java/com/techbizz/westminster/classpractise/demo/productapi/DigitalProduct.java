package com.techbizz.westminster.classpractise.demo.productapi;

public class DigitalProduct extends Product {
    private String downloadUrl;
    private double fileSizeMB;

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public double getFileSizeMB() {
        return this.fileSizeMB;
    }
}
