package com.issuetracker.engine.service;

import com.issuetracker.engine.model.UserType;

import java.util.List;

public interface UserTypeService {
    List<UserType> findAll();

}