package org.arcsoft.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.arcsoft.dto.error.ErrorResponse;
import org.arcsoft.dto.users.ProductDto;
import org.arcsoft.exception.NotFoundException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductIntegrationService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public List<ProductDto> getUserProducts(Long userId) {
        return restClient.get()
                .uri("/users/{userId}/products", userId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(s -> s.value() == 404, (req, res) -> {
                    var errorDto = objectMapper.readValue(new String(res.getBody().readAllBytes()), ErrorResponse.class);
                    throw new NotFoundException(errorDto.message());
                })
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public ProductDto getProduct(Long productId) {
        return restClient.get()
                .uri("/products/{id}", productId)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(s -> s.value() == 404, (req, res) -> {
                    var errorDto = objectMapper.readValue(new String(res.getBody().readAllBytes()), ErrorResponse.class);
                    throw new NotFoundException(errorDto.message());
                })
                .body(ProductDto.class);
    }
}
