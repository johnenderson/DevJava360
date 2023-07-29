package com.issuetracker.engine.service.impl;

import com.issuetracker.engine.dto.PaymentProcessDto;
import com.issuetracker.engine.dto.wsraspay.CustomerDto;
import com.issuetracker.engine.dto.wsraspay.OrderDto;
import com.issuetracker.engine.dto.wsraspay.PaymentDto;
import com.issuetracker.engine.exception.BussinessException;
import com.issuetracker.engine.exception.NotFoundException;
import com.issuetracker.engine.integration.WsRaspayIntegration;
import com.issuetracker.engine.mapper.UserPaymentInfoMapper;
import com.issuetracker.engine.mapper.wsraspay.CreditCardMapper;
import com.issuetracker.engine.mapper.wsraspay.CustomerMapper;
import com.issuetracker.engine.mapper.wsraspay.OrderMapper;
import com.issuetracker.engine.mapper.wsraspay.PaymentMapper;
import com.issuetracker.engine.model.User;
import com.issuetracker.engine.model.UserPaymentInfo;
import com.issuetracker.engine.repository.UserPaymentInfoRepository;
import com.issuetracker.engine.repository.UserRepository;
import com.issuetracker.engine.service.PaymentInfoService;

import java.util.Objects;

public class PaymentInfoServiceImpl implements PaymentInfoService {

    private UserRepository userRepository;
    private final UserPaymentInfoRepository userPaymentInfoRepository;
    private final WsRaspayIntegration wsRaspayIntegration;

    PaymentInfoServiceImpl(UserRepository userRepository, UserPaymentInfoRepository userPaymentInfoRepository, WsRaspayIntegration wsRaspayIntegration){
        this.userRepository = userRepository;
        this.userPaymentInfoRepository = userPaymentInfoRepository;
        this.wsRaspayIntegration = wsRaspayIntegration;
    }

    @Override

    public Boolean process(PaymentProcessDto dto) {
        //verifica o usuario por id
        var userOpt = userRepository.findById(dto.getUserPaymentInfoDto().getUserId());
        if (userOpt.isEmpty()) {
            throw new NotFoundException("Usuário não encontrado");
        }
        User user = userOpt.get();
        if (Objects.nonNull(user.getSubscriptionsType())) {
            throw new BussinessException("Pagamento não pode ser processado pois o usuário já possui assinatura");
        }
        //cria ou atualiza usuario no raspay
        CustomerDto customerDto = wsRaspayIntegration.createCustomer(CustomerMapper.build(user));
        //cria o pedido de pagamento
        OrderDto orderDto = wsRaspayIntegration.createOrder(OrderMapper.build(customerDto.getId(), dto));
        //processa o pagamento
        PaymentDto paymentDto = PaymentMapper.build(customerDto.getId(), orderDto.getId(), CreditCardMapper.build(dto.getUserPaymentInfoDto(), user.getCpf()));
        Boolean successPayment = wsRaspayIntegration.processPayment(paymentDto);

        if (successPayment) {
            //salvar informacoes de pagamento
            UserPaymentInfo userPaymentInfo = UserPaymentInfoMapper.fromDtoToEntity(dto.getUserPaymentInfoDto(), user);
            userPaymentInfoRepository.save(userPaymentInfo);
        }

        // enviar e-mail de criacao de conta
        // retorna o sucsso ou nao do pagamento

        return null;
    }
}
