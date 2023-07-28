package com.issuetracker.engine.service.impl;

import com.issuetracker.engine.model.UserType;
import com.issuetracker.engine.repository.UserTypeRepository;
import com.issuetracker.engine.service.UserTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository userTypeRepository;

    UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public List<UserType> findAll() {
        return userTypeRepository.findAll();
    }


}
