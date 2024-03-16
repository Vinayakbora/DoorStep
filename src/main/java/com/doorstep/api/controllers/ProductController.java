package com.doorstep.api.controllers;

import com.doorstep.api.beans.ResponseHandler;
import com.doorstep.api.models.Product;
import com.doorstep.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        return ResponseHandler.createResponse("Found Products", HttpStatus.OK, productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id) {
        Product product = productService.getProduct(id);
        return ResponseHandler.createResponse("Found Product", HttpStatus.OK, product);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Product product) {

        Object createdProduct = productService.createProduct(product);
        return ResponseHandler.createResponse("Product Created", HttpStatus.CREATED, createdProduct);

    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return String.valueOf(new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK));
    }
}
