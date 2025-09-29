package org.arcsoft.dto.payments;

import java.util.List;

public record PaymentsResponse(List<PaymentDto> payments) {
}
