package com.techbizz.westminster.classpractise.demo.productapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private int nextId = 1;

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name)).toList();
    }

    public Product addProduct(Product product) {
        DigitalProduct dp = new DigitalProduct(112,
                "Digital Product",
                2,
                true,
                34.99,
                "http://xsdfa.com/file/3434",
                23.33);


        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public List<Product> addGetInheritedProduct() {
        Product p = new Product(133,
                "Base Product",
                10,
                true,
                10.99);
        DigitalProduct dp = new DigitalProduct(112,
                "Digital Product",
                2,
                true,
                34.99,
                "http://xsdfa.com/file/3434",
                23.33);
        PhysicalProduct physicalProduct = new PhysicalProduct(122,
                "Physical Product",
                3,
                true,
                11.99,
                3.09,
                "20x10");
        products.add(p);
        products.add(dp);
        products.add(physicalProduct);
        return this.products;
    }
    public void deleteProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }
}
