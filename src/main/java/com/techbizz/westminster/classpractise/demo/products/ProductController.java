package com.techbizz.westminster.classpractise.demo.products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
