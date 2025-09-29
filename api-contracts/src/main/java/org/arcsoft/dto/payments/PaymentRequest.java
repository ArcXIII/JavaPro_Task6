package org.arcsoft.dto.payments;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Valid
public record PaymentRequest(@NotNull Long userId, @NotNull Long productId, @DecimalMin("0.01") Double amount) {
}
