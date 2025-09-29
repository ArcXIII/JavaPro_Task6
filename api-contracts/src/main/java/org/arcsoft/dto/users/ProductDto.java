package org.arcsoft.dto.users;

public record ProductDto(Long id, String accountNumber, Double balance, ProductType type) {
}
