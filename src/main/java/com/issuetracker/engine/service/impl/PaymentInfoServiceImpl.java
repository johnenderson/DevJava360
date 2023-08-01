package com.issuetracker.engine.service.impl;

import com.issuetracker.engine.dto.PaymentProcessDto;
import com.issuetracker.engine.dto.wsraspay.CustomerDto;
import com.issuetracker.engine.dto.wsraspay.OrderDto;
import com.issuetracker.engine.dto.wsraspay.PaymentDto;
import com.issuetracker.engine.enums.UserTypeEnum;
import com.issuetracker.engine.exception.BussinessException;
import com.issuetracker.engine.exception.NotFoundException;
import com.issuetracker.engine.integration.MailIntegration;
import com.issuetracker.engine.integration.WsRaspayIntegration;
import com.issuetracker.engine.mapper.UserPaymentInfoMapper;
import com.issuetracker.engine.mapper.wsraspay.CreditCardMapper;
import com.issuetracker.engine.mapper.wsraspay.CustomerMapper;
import com.issuetracker.engine.mapper.wsraspay.OrderMapper;
import com.issuetracker.engine.mapper.wsraspay.PaymentMapper;
import com.issuetracker.engine.model.User;
import com.issuetracker.engine.model.UserCredentials;
import com.issuetracker.engine.model.UserPaymentInfo;
import com.issuetracker.engine.repository.*;
import com.issuetracker.engine.service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {

    @Value("${configuration.default.password}")
    private String defaultPassword;

    private final UserRepository userRepository;
    private final UserPaymentInfoRepository userPaymentInfoRepository;
    private final WsRaspayIntegration wsRaspayIntegration;
    private final MailIntegration mailIntegration;
    private final UserDetailsRepository userDetailsRepository;
    private final UserTypeRepository userTypeRepository;
    private final SubscriptionsTypeRepository subscriptionsTypeRepository;

    PaymentInfoServiceImpl(UserRepository userRepository, UserPaymentInfoRepository userPaymentInfoRepository,
                           WsRaspayIntegration wsRaspayIntegration, MailIntegration mailIntegration,
                           UserDetailsRepository userDetailsRepository, UserTypeRepository userTypeRepository, SubscriptionsTypeRepository subscriptionsTypeRepository) {
        this.userRepository = userRepository;
        this.userPaymentInfoRepository = userPaymentInfoRepository;
        this.wsRaspayIntegration = wsRaspayIntegration;
        this.mailIntegration = mailIntegration;
        this.userDetailsRepository = userDetailsRepository;
        this.userTypeRepository = userTypeRepository;
        this.subscriptionsTypeRepository = subscriptionsTypeRepository;
    }

    @Override
    public Boolean process(PaymentProcessDto dto) {
        var userOpt = userRepository.findById(dto.getUserPaymentInfoDto().getUserId());
        if (userOpt.isEmpty()) {
            throw new NotFoundException("Usuário não encontrado");
        }

        User user = userOpt.get();
        if (Objects.nonNull(user.getSubscriptionsType())) {
            throw new BussinessException("Pagamento não pode ser processado pois o usuário já possui assinatura");
        }

        Boolean successPayment = getSuccessPayment(dto, user);

        return createUserCredentials(dto, successPayment, user);
    }

    private boolean createUserCredentials(PaymentProcessDto dto, Boolean successPayment, User user) {
        if (Boolean.TRUE.equals(successPayment)) {
            UserPaymentInfo userPaymentInfo = UserPaymentInfoMapper.fromDtoToEntity(dto.getUserPaymentInfoDto(), user);
            userPaymentInfoRepository.save(userPaymentInfo);

            var userTypeOpt = userTypeRepository.findById(UserTypeEnum.ALUNO.getId());

            if (userTypeOpt.isEmpty()) {
                throw new NotFoundException("UserType não encontrado");
            }

            UserCredentials userCredentials = new UserCredentials(null, user.getEmail(), new BCryptPasswordEncoder().encode(defaultPassword), userTypeOpt.get());
            userDetailsRepository.save(userCredentials);

            var subscriptionsTypeOpt = subscriptionsTypeRepository.findByProductKey(dto.getProductKey());

            if(subscriptionsTypeOpt.isEmpty()){
                throw new NotFoundException("SubscriptionsType não encontrado");
            }

            user.setSubscriptionsType(subscriptionsTypeOpt.get());
            userRepository.save(user);

            mailIntegration.send(user.getEmail(), "Usuário: " + user.getEmail() + " - Senha: " + defaultPassword, "Acesso Liberado!");
            return true;
        }

        return false;
    }

    private Boolean getSuccessPayment(PaymentProcessDto dto, User user) {
        CustomerDto customerDto = wsRaspayIntegration.createCustomer(CustomerMapper.build(user));
        OrderDto orderDto = wsRaspayIntegration.createOrder(OrderMapper.build(customerDto.getId(), dto));
        PaymentDto paymentDto = PaymentMapper.build(customerDto.getId(), orderDto.getId(), CreditCardMapper.build(dto.getUserPaymentInfoDto(), user.getCpf()));
        return wsRaspayIntegration.processPayment(paymentDto);
    }
}
