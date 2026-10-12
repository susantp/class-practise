package com.techbizz.westminster.classpractise.demo.productapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public List<Product> all() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getProductById(id)
                .orElse(null); // Lecture 6
    }

    @PostMapping("/")
    public Product add(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/all-single")
    public Map<String, Object> allSingleInstance() {
        List<Product> productList = new ArrayList<>();
        int id = 123;
        Product product = new Product(id, "Product-" + id, 20, true, 199.99);
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

}
