package com.issuetracker.engine.integration;

import com.issuetracker.engine.dto.wsraspay.CreditCardDto;
import com.issuetracker.engine.dto.wsraspay.CustomerDto;
import com.issuetracker.engine.dto.wsraspay.OrderDto;
import com.issuetracker.engine.dto.wsraspay.PaymentDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class WsRaspayIntegrationImplTest {

    @Autowired
    private WsRaspayIntegration wsRaspayIntegration;

    @Test
    void createCustomerWhenDTOOK(){
        CustomerDto dto = new CustomerDto(null,"19738794846","johnenderson@outlook.com","John","Silva");
        wsRaspayIntegration.createCustomer(dto);
    }

    @Test
    void createOrderWhenDTOOK(){
        OrderDto dto = new OrderDto(null, "64c4282b6a87b8165ad6482b", BigDecimal.ZERO, "MONTH22");
        wsRaspayIntegration.createOrder(dto);
    }

    @Test
    void processPaymentWhenDtoOK(){
        CreditCardDto creditCardDto = new CreditCardDto(123L, "19738794846", 0L,06L,"123412341234",2025L);
        PaymentDto paymentDto = new PaymentDto(creditCardDto, "64c4282b6a87b8165ad6482b", "");
        wsRaspayIntegration.processPayment(paymentDto);
    }


}
