package com.issuetracker.engine.integration;

import com.issuetracker.engine.dto.wsraspay.CustomerDto;
import com.issuetracker.engine.dto.wsraspay.OrderDto;
import com.issuetracker.engine.dto.wsraspay.PaymentDto;

public interface WsRaspayIntegration {

    CustomerDto createCustomer(CustomerDto dto);

    OrderDto createOrder(OrderDto dto);

    Boolean processPayment(PaymentDto dto);
}
