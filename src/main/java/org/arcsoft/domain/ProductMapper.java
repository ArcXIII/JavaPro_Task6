package org.arcsoft.domain;

import org.arcsoft.domain.dto.CreateProductRequest;
import org.arcsoft.domain.dto.ProductDto;
import org.arcsoft.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    Product toEntity(CreateProductRequest dto);

    ProductDto toDto(Product entity);

    List<ProductDto> toDto(List<Product> entity);
}
