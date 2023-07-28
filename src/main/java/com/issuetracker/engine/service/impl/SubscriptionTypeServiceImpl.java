package com.issuetracker.engine.service.impl;

import com.issuetracker.engine.controller.SubscriptionTypeController;
import com.issuetracker.engine.dto.SubscriptionTypeDto;
import com.issuetracker.engine.exception.BadRequestException;
import com.issuetracker.engine.exception.NotFoundException;
import com.issuetracker.engine.mapper.SubscriptionTypeMapper;
import com.issuetracker.engine.model.SubscriptionType;
import com.issuetracker.engine.repository.SubscriptionsTypeRepository;
import com.issuetracker.engine.service.SubscriptionTypeService;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SubscriptionTypeServiceImpl implements SubscriptionTypeService {

    private static final String UPDATE = "update";
    private static final String DELETE = "delete";

    private final SubscriptionsTypeRepository subscriptionsTypeRepository;

    SubscriptionTypeServiceImpl(SubscriptionsTypeRepository subscriptionsTypeRepository) {
        this.subscriptionsTypeRepository = subscriptionsTypeRepository;
    }

    @Override
    public List<SubscriptionType> findAll() {
        return subscriptionsTypeRepository.findAll();
    }

    @Override
    public SubscriptionType findById(Long id) {
          return getSubscriptionType(id).add(WebMvcLinkBuilder.linkTo(
                  WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class).findById(id))
                  .withSelfRel()
          ).add(WebMvcLinkBuilder.linkTo(
                  WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class).update(id, new SubscriptionTypeDto()))
                  .withRel(UPDATE)
          ).add(WebMvcLinkBuilder.linkTo(
                  WebMvcLinkBuilder.methodOn(SubscriptionTypeController.class).delete(id))
                  .withRel(DELETE)
          );
    }

    @Override
    public SubscriptionType create(SubscriptionTypeDto dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Id deve ser nulo");
        }
        return subscriptionsTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public SubscriptionType update(Long id, SubscriptionTypeDto dto) {
        getSubscriptionType(id);
        dto.setId(id);
        return subscriptionsTypeRepository.save(SubscriptionTypeMapper.fromDtoToEntity(dto));
    }

    @Override
    public void delete(Long id) {
        getSubscriptionType(id);
        subscriptionsTypeRepository.deleteById(id);
    }

    private SubscriptionType getSubscriptionType(Long id) {
        Optional<SubscriptionType> optionalSubscriptionsType = subscriptionsTypeRepository.findById(id);
        if (optionalSubscriptionsType.isEmpty()) {
            throw new NotFoundException("SubscriptionType não encontrado");
        }
        return optionalSubscriptionsType.get();
    }
}
