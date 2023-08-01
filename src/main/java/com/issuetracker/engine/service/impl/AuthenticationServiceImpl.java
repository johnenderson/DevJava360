package com.issuetracker.engine.service.impl;

import com.issuetracker.engine.dto.LoginDto;
import com.issuetracker.engine.dto.TokenDto;
import com.issuetracker.engine.exception.BadRequestException;
import com.issuetracker.engine.model.UserCredentials;
import com.issuetracker.engine.service.AuthenticationService;
import com.issuetracker.engine.service.TokenService;
import com.issuetracker.engine.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TokenService tokenService;

    @Override
    public TokenDto auth(LoginDto dto) {
        try {
            UserCredentials userCredentials = userDetailsService.loadUserByUsernameAndPass(dto.getUsername(), dto.getPassword());
            String token = tokenService.getToken(userCredentials.getId());
            return TokenDto.builder().token(token).type("Bearer").build();
        } catch (Exception e) {
            throw new BadRequestException("Erro ao formatar token - "+e.getMessage());
        }
    }

}
