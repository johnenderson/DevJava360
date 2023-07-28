package com.issuetracker.engine.service.impl;

import com.issuetracker.engine.dto.UserDto;
import com.issuetracker.engine.exception.BadRequestException;
import com.issuetracker.engine.exception.NotFoundException;
import com.issuetracker.engine.mapper.UserMapper;
import com.issuetracker.engine.model.User;
import com.issuetracker.engine.model.UserType;
import com.issuetracker.engine.repository.UserRepository;
import com.issuetracker.engine.repository.UserTypeRepository;
import com.issuetracker.engine.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserTypeRepository userTypeRepository;

    UserServiceImpl(UserRepository userRepository, UserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public User create(UserDto dto) {

        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("ID deve ser nulo");
        }

        var userTypeOpt = userTypeRepository.findById(dto.getUserTypeId());

        if (userTypeOpt.isEmpty()) {
            throw new NotFoundException("getUserTypeId não encontrado");
        }

        UserType userType = userTypeOpt.get();
        User user = UserMapper.fromDtoToEntity(dto, userType, null);
        return userRepository.save(user);

    }
}
