package org.arcsoft.service;

import lombok.RequiredArgsConstructor;
import org.arcsoft.domain.PaymentMapper;
import org.arcsoft.dto.payments.PaymentDto;
import org.arcsoft.dto.payments.PaymentRequest;
import org.arcsoft.exception.NotEnoughMoneyException;
import org.arcsoft.integration.ProductIntegrationService;
import org.arcsoft.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final ProductIntegrationService productIntegrationService;
    private final PaymentRepository repository;
    private final PaymentMapper mapper;


    public PaymentDto pay(PaymentRequest paymentRequest) {
        var targetProduct = productIntegrationService.getProduct(paymentRequest.productId());

        if (targetProduct.balance() < paymentRequest.amount()) {
            throw new NotEnoughMoneyException("Not enough money on balance");
        }

        return mapper.toDto(repository.save(mapper.fromRequest(paymentRequest)));
    }


    public List<PaymentDto> getUserPayments(final Long userId) {
        return mapper.toDto(repository.getByUserId(userId));
    }
}
