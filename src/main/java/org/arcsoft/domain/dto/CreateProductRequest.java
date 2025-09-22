package org.arcsoft.domain.dto;

import org.arcsoft.domain.entity.ProductType;

public record CreateProductRequest(String accountNumber, Double balance, ProductType type) {
}
