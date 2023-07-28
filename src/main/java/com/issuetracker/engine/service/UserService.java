package com.issuetracker.engine.service;

import com.issuetracker.engine.dto.UserDto;
import com.issuetracker.engine.model.User;

public interface UserService {

    User create(UserDto dto);
}