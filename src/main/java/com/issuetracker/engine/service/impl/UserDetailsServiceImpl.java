package com.issuetracker.engine.service.impl;

import com.issuetracker.engine.exception.BadRequestException;
import com.issuetracker.engine.exception.NotFoundException;
import com.issuetracker.engine.model.UserCredentials;
import com.issuetracker.engine.repository.UserDetailsRepository;
import com.issuetracker.engine.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserCredentials loadUserByUsernameAndPass(String username, String pass) {
        var userCredentialsOpt = userDetailsRepository.findByUsername(username);

        if (userCredentialsOpt.isEmpty()){
            throw new NotFoundException("Usuário não encontrado");
        }

        UserCredentials userCredentials = userCredentialsOpt.get();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (encoder.matches(pass, userCredentials.getPassword())){
            return userCredentials;
        }

        throw new BadRequestException("Usuário ou senha inválido");

    }

}
