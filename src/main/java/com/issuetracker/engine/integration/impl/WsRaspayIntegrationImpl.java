package com.issuetracker.engine.integration.impl;

import com.issuetracker.engine.dto.wsraspay.CustomerDto;
import com.issuetracker.engine.dto.wsraspay.OrderDto;
import com.issuetracker.engine.dto.wsraspay.PaymentDto;
import com.issuetracker.engine.integration.WsRaspayIntegration;
import jakarta.annotation.PostConstruct;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WsRaspayIntegrationImpl implements WsRaspayIntegration {

    @Value("${api.raspay.host}")
    private String raspayHost;
    @Value("${api.raspay.credential}")
    private String raspayCredential;
    @Value("${api.raspay.v1.customer}")
    private String customerURI;
    @Value("${api.raspay.v1.order}")
    private String orderURI;
    @Value("${api.raspay.v1.payment}")
    private String paymentURI;
    private final RestTemplate restTemplate;
    private HttpHeaders headers;

    public WsRaspayIntegrationImpl() {
        restTemplate = new RestTemplate();
    }

    @PostConstruct
    public void init() {
        headers = getHttpHeaders();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto dto) {
        try {
            HttpEntity<CustomerDto> request = new HttpEntity<>(dto, this.headers);
            ResponseEntity<CustomerDto> response =
                    restTemplate.exchange(raspayHost + customerURI, HttpMethod.POST, request, CustomerDto.class);
            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        try {
            HttpEntity<OrderDto> request = new HttpEntity<>(dto, this.headers);
            ResponseEntity<OrderDto> response =
                    restTemplate.exchange(raspayHost + orderURI, HttpMethod.POST, request, OrderDto.class);
            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Boolean processPayment(PaymentDto dto) {
        try {
            HttpEntity<PaymentDto> request = new HttpEntity<>(dto, this.headers);
            ResponseEntity<Boolean> response =
                    restTemplate.exchange(raspayHost + paymentURI, HttpMethod.POST, request, Boolean.class);
            return response.getBody();
        } catch (Exception e) {
            throw e;
        }
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String base64 = Base64.encodeBase64String(raspayCredential.getBytes());
        headers.add("Authorization", "Basic " + base64);
        return headers;
    }
}
