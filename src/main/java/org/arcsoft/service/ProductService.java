package org.arcsoft.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.arcsoft.domain.ProductMapper;
import org.arcsoft.domain.dto.CreateProductRequest;
import org.arcsoft.domain.dto.ProductDto;
import org.arcsoft.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public ProductDto getById(Long id) {
        return mapper.toDto(productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product with id " + id + " not found")));
    }

    public List<ProductDto> getByUserId(Long userId) {
        return mapper.toDto(productRepository.findByUserId(userId));
    }

    public ProductDto addProduct(Long userId, CreateProductRequest dto) {
        var product = mapper.toEntity(dto);
        product.setUserId(userId);
        return mapper.toDto(productRepository.save(product));
    }

    public List<ProductDto> getAll() {
        return mapper.toDto(productRepository.findAll());
    }
}
