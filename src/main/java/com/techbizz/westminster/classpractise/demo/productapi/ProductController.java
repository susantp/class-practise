package com.techbizz.westminster.classpractise.demo.productapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Object getById(@PathVariable int id) {
        try {
            return productService.getProductById(id);

        } catch (RuntimeException e) {
            return Map.of("error", "Product not found");
        }
    }

    @PostMapping("/")
    public Product add(@RequestBody CreateProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }

    @GetMapping("/inherited")
    public List<Product> inherited() {
        return productService.addGetInheritedProduct();
    }

    @GetMapping("/override")
    public List<String> override() {
        productService.addGetInheritedProduct();
        List<String> overrideList = new ArrayList<>();
        productService.getAllProducts().forEach(product -> {
            overrideList.add(product.getSummary());
        });
        return overrideList;
    }

    @GetMapping("/getDiscountedProducts")
    public List<Product> applyDiscount() {
        List<Product> products = productService.addGetInheritedProduct();
        productService.applyDiscounts(products);
        return productService.getDiscountedProducts();
    }
}
