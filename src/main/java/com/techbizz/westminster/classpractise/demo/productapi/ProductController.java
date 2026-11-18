package com.techbizz.westminster.classpractise.demo.productapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Product> getById(@PathVariable int id) {
        /***
            try {
                Product product = productService.getProductById(id);
                return ResponseEntity.ok(product);
            }catch (Exception ex){
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse(
                                ex.getMessage(), HttpStatus.NOT_FOUND.value()
                        ));
            }
        ***/
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@RequestBody CreateProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }

    @GetMapping("/inherited")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> inherited() {
        return productService.addGetInheritedProduct();
    }

    @GetMapping("/override")
    @ResponseStatus(HttpStatus.OK)
    public List<String> override() {
        productService.addGetInheritedProduct();
        List<String> overrideList = new ArrayList<>();
        productService.getAllProducts().forEach(product -> {
            overrideList.add(product.getSummary());
        });
        return overrideList;
    }

    @GetMapping("/getDiscountedProducts")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> applyDiscount() {
        List<Product> products = productService.addGetInheritedProduct();
        productService.applyDiscounts(products);
        return productService.getDiscountedProducts();
    }
}
