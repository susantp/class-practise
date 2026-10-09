package com.techbizz.westminster.classpractise.demo;

import com.techbizz.westminster.classpractise.demo.productapi.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    public void testProduct() {
        Product product = new Product(11, "Laptop", 20, true, 12.33);
        assertEquals(113, product.getId());
        assertEquals("Laptop", product.getName());
    }
}
