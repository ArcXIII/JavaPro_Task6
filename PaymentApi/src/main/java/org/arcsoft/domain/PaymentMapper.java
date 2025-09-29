package org.arcsoft.domain;

import org.arcsoft.domain.entity.Payment;
import org.arcsoft.dto.payments.PaymentDto;
import org.arcsoft.dto.payments.PaymentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PaymentMapper {

    @Mapping(target = "paymentAmount", source = "amount")
    PaymentDto toDto(Payment payment);

    List<PaymentDto> toDto(List<Payment> payment);

    @Mapping(target = "id", ignore = true)
    Payment fromRequest(PaymentRequest paymentRequest);
}
