package com.dating.server.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Data
public class LikeRequest {

    @NotNull
    private Long userId;

    private boolean like;
}
