//package com.dating.server.service;
//
//import com.dating.server.Xmpp.DataJpa.XmppUser;
//import com.dating.server.Xmpp.DataJpa.XmppUserRepository;
//import lombok.extern.apachecommons.CommonsLog;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpSession;
//
//@Service
//@CommonsLog(topic = "AuthService")
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//
//public class AuthService {
//
//    @Autowired
//    AuthenticationManager authManager;
//
//    @Autowired
//    XmppUserRepository userRepository;
//
//    public XmppUser register(String username, String password) throws Exception {
//        XmppUser user = new XmppUser();
//        user.setUsername(username);
//        user.setPassword(password);
//        userRepository.save(user);
//        return user;
//    }
//
//    public void signIn() {
//    }
//
//    public void authenticate(String username, String password, HttpSession httpSession) throws Exception {
//        log.info("authenticate");
//        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
//        Authentication auth = authManager.authenticate(authReq);
//        log.info(auth.isAuthenticated());
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//        securityContext.setAuthentication(auth);
//        httpSession.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
//    }
//}
