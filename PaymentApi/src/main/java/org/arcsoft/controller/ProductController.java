package org.arcsoft.controller;

import lombok.RequiredArgsConstructor;
import org.arcsoft.dto.payments.UserProductsDto;
import org.arcsoft.integration.ProductIntegrationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductIntegrationService productIntegrationService;

    @GetMapping("/payments/{userId}/products")
    public UserProductsDto getUserProducts(@PathVariable Long userId) {
        final var products = productIntegrationService.getUserProducts(userId);
        return new UserProductsDto(products);
    }
}
