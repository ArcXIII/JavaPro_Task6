package org.arcsoft.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.arcsoft.dto.payments.PaymentDto;
import org.arcsoft.dto.payments.PaymentRequest;
import org.arcsoft.dto.payments.PaymentsResponse;
import org.arcsoft.service.PaymentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payments")
    public PaymentDto getUserProducts(@Valid @RequestBody PaymentRequest paymentRequest) {
        return paymentService.pay(paymentRequest);
    }

    @GetMapping("/payments/{userId}")
    public PaymentsResponse getUserPayments(@PathVariable Long userId) {
        return new PaymentsResponse(paymentService.getUserPayments(userId));
    }
}
