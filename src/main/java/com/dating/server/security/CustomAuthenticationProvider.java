//package com.dating.server.security;
//
//import com.dating.server.Xmpp.DataJpa.XmppUser;
//import com.dating.server.Xmpp.DataJpa.XmppUserRepository;
//import lombok.extern.apachecommons.CommonsLog;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//
//@Component
//@CommonsLog(topic = "CustomAuthenticationProvider")
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    XmppUserRepository userRepository;
//
//    @Override
//    public Authentication authenticate(Authentication auth)
//            throws AuthenticationException {
//        String username = auth.getName();
//        String password = auth.getCredentials()
//                .toString();
//        XmppUser user = userRepository.findByUsername(username);
//        if (user == null){
//            throw new
//                    AuthenticationCredentialsNotFoundException("No user found");
//        }
//        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
//            return new UsernamePasswordAuthenticationToken
//                    (username, password, Collections.emptyList());
//        } else {
//            throw new
//                    BadCredentialsException("External system authentication failed");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> auth) {
//        return auth.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}