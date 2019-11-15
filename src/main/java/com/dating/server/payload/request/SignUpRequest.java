package com.dating.server.payload.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Data
public class SignUpRequest {

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;


    @NotBlank
    @Size(min = 6, max = 20)
    private String password;


}
