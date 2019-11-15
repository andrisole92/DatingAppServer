package com.dating.server.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Data
public class LikeRequest {

    @NotBlank
    private String likedUsername;

    private boolean like;
}
