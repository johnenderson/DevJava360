package com.issuetracker.engine.service;

import com.issuetracker.engine.dto.LoginDto;
import com.issuetracker.engine.dto.TokenDto;

public interface AuthenticationService {

    TokenDto auth(LoginDto dto);

}
