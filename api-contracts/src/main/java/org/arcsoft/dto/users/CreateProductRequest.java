package org.arcsoft.dto.users;

public record CreateProductRequest(String accountNumber, Double balance, ProductType type) {
}
