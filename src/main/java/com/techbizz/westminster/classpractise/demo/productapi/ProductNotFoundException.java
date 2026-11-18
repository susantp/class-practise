package com.techbizz.westminster.classpractise.demo.productapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int id) {
        super("Product not found with id: "
                + id);
    }
}
