package com.dating.server.Controllers;


import com.dating.server.Services.AuthService;
import com.dating.server.Xmpp.DataJpa.XmppUser;
import com.dating.server.Xmpp.DataJpa.XmppUserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("auth2")
@CommonsLog(topic = "AuthController")
public class AuthController {

    @Autowired
    AuthService authService;

    final
    XmppUserRepository xmppUserRepository;

    final
    AuthenticationManager authManager;

    public AuthController(XmppUserRepository xmppUserRepository, AuthenticationManager authManager) {
        this.xmppUserRepository = xmppUserRepository;
        this.authManager = authManager;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Auth Controller!";
    }


    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    @ResponseBody
    public AuthResponse authenticate(@RequestParam(defaultValue = "0") String username,
                                     @RequestParam(defaultValue = "0") String password, HttpSession httpSession) {

        log.info("authenticate, username:" + username + ",password:" + password);
        XmppUser user = xmppUserRepository.findByUsername(username);
        if (user == null) {
            try {
                XmppUser newUser = authService.register(username,password);
                authService.authenticate(username, password, httpSession);
                return new AuthResponse(true, newUser, "User created");
            } catch (Exception e) {
                e.printStackTrace();
                return new AuthResponse(false, null, e.getMessage());
            }
        }
        // Authenticate here or create the new user if doesn't exist.
        try {
            UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
            Authentication auth = authManager.authenticate(authReq);
            log.info(auth.isAuthenticated());
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(auth);
            httpSession.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
            httpSession.setAttribute("test", "test");
//            authService.authenticate(username, password, httpSession);
        } catch (Exception e) {
            e.printStackTrace();
            return new AuthResponse(false, null, e.getMessage());
        }

        return new AuthResponse(true, user, "Authenticated");
    }

}

@AllArgsConstructor
@Getter
@Setter
class AuthResponse {
    boolean success;
    XmppUser user;
    String message;
}