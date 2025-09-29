package org.arcsoft.dto.payments;

public record PaymentDto(Long id, Long userId, Long productId, Double paymentAmount) {
}
