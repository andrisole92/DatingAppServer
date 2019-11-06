package com.dating.server.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Data
@AllArgsConstructor
public class SendMessageRequest {

    @NotNull
    private Long channelId;

    @NotBlank
    @Size(min = 1, max = 1000)
    private String body;


}
