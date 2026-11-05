package com.techbizz.westminster.classpractise.demo.productapi;

public record CreateProductRequest(
        String name,
        int qty,
        boolean inStock,
        double unitPrice
        
) {
}
