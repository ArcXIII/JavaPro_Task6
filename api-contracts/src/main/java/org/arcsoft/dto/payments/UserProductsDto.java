package org.arcsoft.dto.payments;

import org.arcsoft.dto.users.ProductDto;

import java.util.List;

public record UserProductsDto(List<ProductDto> products) {
}
