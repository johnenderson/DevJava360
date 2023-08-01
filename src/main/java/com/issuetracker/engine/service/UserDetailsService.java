package com.issuetracker.engine.service;

import com.issuetracker.engine.model.UserCredentials;

public interface UserDetailsService{

    UserCredentials loadUserByUsernameAndPass(String username, String pass);

}
