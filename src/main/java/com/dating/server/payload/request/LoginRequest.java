package com.dating.server.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class LoginRequest {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;
}
