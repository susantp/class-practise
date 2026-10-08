package com.techbizz.westminster.classpractise.demo.productapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/getAddress/{city}")
    public String getAddress(@PathVariable String city){
        Address address = new Address(222, city, "bagmati", "nepal");

        return address.getFullAddress();
    }
    @GetMapping("/")
    public String hello() {
        /**
         * Procedural Code
         */
        // Data
        int personId = 123;
        String personName = "Jeevan";

        int productId = 123;
        String productName = "Laptop";
        int qty = 2;
        boolean inStock = true;
        double unitPrice = 13.99;

        // Logic
        double total = qty * unitPrice;

        // Output
        return personName + " buys " + productName
                + " amount total: " + total;

        /**
         * OOP Code
         */
        // Product product = new Product(123, "Laptop", 2, true, 13.99);
        // Person person = new Person(123, "Jeevan");
        // return person.buysProduct(product);
    }
}
