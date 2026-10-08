package com.techbizz.westminster.classpractise.demo.productapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/all")
    public List<Product> all() {
        List<Product> productList = new ArrayList<>();
        int id = 123;

        for (int index = 0; index <= 4; index++) {
            id += index;
            productList.add(new Product(
                    id + index,
                    "Product-" + id + index,
                    20,
                    id % 2 == 0,
                    199.99 + index
            ));
        }
        return productList;
    }
}
