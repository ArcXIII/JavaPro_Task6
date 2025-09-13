package org.arcsoft.domain.dto;

import org.arcsoft.domain.entity.ProductType;


public record ProductDto(Long id, String accountNumber, Double balance, ProductType type) {
}
