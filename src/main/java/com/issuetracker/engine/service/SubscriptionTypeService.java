package com.issuetracker.engine.service;

import com.issuetracker.engine.dto.SubscriptionTypeDto;
import com.issuetracker.engine.model.SubscriptionType;

import java.util.List;

public interface SubscriptionTypeService {

    List<SubscriptionType> findAll();

    SubscriptionType findById(Long id);

    SubscriptionType create(SubscriptionTypeDto dto);

    SubscriptionType update(Long id, SubscriptionTypeDto dto);

    void delete(Long id);

}