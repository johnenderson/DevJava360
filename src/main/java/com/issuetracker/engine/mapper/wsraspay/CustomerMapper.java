package com.issuetracker.engine.mapper.wsraspay;

import com.issuetracker.engine.dto.wsraspay.CustomerDto;
import com.issuetracker.engine.model.User;

public class CustomerMapper {

    public static CustomerDto build(User user ) {

        var fullName = user.getName().split(" ");
        var firstName = fullName[0];
        var lastName = fullName.length > 1 ? fullName[fullName.length -1]: "";

        return CustomerDto.builder()
                .cpf(user.getCpf())
                .email(user.getEmail())
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
