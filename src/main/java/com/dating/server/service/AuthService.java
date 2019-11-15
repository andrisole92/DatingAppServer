package com.dating.server.service;

import com.dating.server.model.User;
import com.dating.server.repository.UserRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "AuthService")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthService {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    UserRepository userRepository;

    public User signUp(String username, String password) throws Exception {
        return new User();
    }

    public void signIn() {
    }

}
