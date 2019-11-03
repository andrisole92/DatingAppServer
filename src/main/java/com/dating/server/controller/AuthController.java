package com.dating.server.controller;


import com.dating.server.exception.AppException;
import com.dating.server.model.Role;
import com.dating.server.model.RoleName;
import com.dating.server.model.User;
import com.dating.server.payload.ApiResponse;
import com.dating.server.payload.JwtAuthenticationResponse;
import com.dating.server.payload.LoginRequest;
import com.dating.server.payload.SignUpRequest;
import com.dating.server.repository.RoleRepository;
import com.dating.server.repository.UserRepository;
import com.dating.server.security.JwtTokenProvider;
//import com.dating.server.service.AuthService;
//import com.dating.server.Xmpp.DataJpa.XmppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
@RequestMapping("auth2")
@CommonsLog(topic = "AuthController")
public class AuthController {

//    @Autowired
//    AuthService authService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

//    public AuthController(XmppUserRepository xmppUserRepository, AuthenticationManager authManager) {
//        this.userRepository = xmppUserRepository;
//        this.authenticationManager = authManager;
//    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Auth Controller!";
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

//        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
//                    HttpStatus.BAD_REQUEST);
//        }

        // Creating user's account
        User user = new User( signUpRequest.getUsername(),
                 signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

}
///*
//
//@AllArgsConstructor
//@Getter
//@Setter
//class AuthResponse {
//    boolean success;
//    XmppUser user;
//    String message;
//}*/
