package com.issuetracker.engine.service;

import com.issuetracker.engine.dto.PaymentProcessDto;

public interface PaymentInfoService {

    Boolean process(PaymentProcessDto dto);
}