package com.issuetracker.engine.mapper.wsraspay;

import com.issuetracker.engine.dto.PaymentProcessDto;
import com.issuetracker.engine.dto.wsraspay.OrderDto;

public class OrderMapper {

    public static OrderDto build(String customerId, PaymentProcessDto paymentProcessDto){
        return OrderDto.builder()
                .customerId(customerId)
                .productAcronym(paymentProcessDto.getProductKey())
                .discount(paymentProcessDto.getDiscount())
                .build();
    }
}
