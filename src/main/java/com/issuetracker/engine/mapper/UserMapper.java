package com.issuetracker.engine.mapper;

import com.issuetracker.engine.dto.UserDto;
import com.issuetracker.engine.model.SubscriptionType;
import com.issuetracker.engine.model.User;
import com.issuetracker.engine.model.UserType;

public class UserMapper {

    public static User fromDtoToEntity(UserDto dto, UserType userType, SubscriptionType subscriptionType) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .phone((dto.getPhone()))
                .dtSubscription(dto.getDtSubscription())
                .dtExpiration(dto.getDtExpiration())
                .userType(userType)
                .subscriptionsType(subscriptionType)
                .build();

    }

}
