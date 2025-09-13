package org.arcsoft.controller;

import lombok.RequiredArgsConstructor;
import org.arcsoft.domain.dto.CreateProductRequest;
import org.arcsoft.domain.dto.ProductDto;
import org.arcsoft.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping("/products")
    public ProductDto addProduct(@RequestBody CreateProductRequest product) {
        return productService.addProduct(product);
    }

    @GetMapping("/users/{userId}/products")
    public List<ProductDto> getUserProducts(@PathVariable Long userId) {
        return productService.getByUserId(userId);
    }
}
