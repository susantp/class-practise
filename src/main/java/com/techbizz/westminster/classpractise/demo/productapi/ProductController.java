package com.techbizz.westminster.classpractise.demo.productapi;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {

        return new Product(
                id,
                "Laptop",
                10,
                true,
                99.99);
    }

    @GetMapping("/all-single")
    public Map<String, Object> allSingleInstance() {
        List<Product> productList = new ArrayList<>();
        int id = 123;
        Product product = new Product(
                id,
                "Product-" + id,
                20,
                true,
                199.99
        );
        for (int index = 0; index <= 4; index++) {
            id += index;
            productList.add(product);

            product.setId(id + index);
            product.setName("Product " + index);
            product.setInStock(id % 2 == 0);
        }

        return Map.of(
                "Total Instance Count", Product.getInstanceCount(),
                "Total Products", productList
        );
    }

    @GetMapping("/all")
    public Map<String, Object> all() {
        List<Product> productList = new ArrayList<>();
        int id = 123;
        for (int index = 0; index <= 4; index++) {
            id += index;
            productList.add(new Product(
                    id + index,
                    "Product-" + id,
                    20,
                    id % 2 == 0,
                    199.99
            ));
        }

        return Map.of(
                "Total Instance Count", Product.getInstanceCount(),
                "Total Products", productList
        );
    }
}
