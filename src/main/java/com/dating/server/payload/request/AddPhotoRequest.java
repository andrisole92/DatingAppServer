package com.dating.server.payload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class AddPhotoRequest {
    @NotNull
    private MultipartFile multipartFile;
}
