package com.issuetracker.engine.mapper.wsraspay;

import com.issuetracker.engine.dto.wsraspay.CreditCardDto;
import com.issuetracker.engine.dto.wsraspay.PaymentDto;

public class PaymentMapper {

    public static PaymentDto build(String customerId, String orderId, CreditCardDto dto){
            return PaymentDto.builder()
                    .customerId(customerId)
                    .orderId(orderId)
                    .creditCard(dto)
                    .build();
    }

}
