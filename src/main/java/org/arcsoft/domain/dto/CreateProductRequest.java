package org.arcsoft.domain.dto;

import org.arcsoft.domain.entity.ProductType;

import java.math.BigDecimal;

public record CreateProductRequest(Long userId, String accountNumber, BigDecimal balance, ProductType type) {
}
