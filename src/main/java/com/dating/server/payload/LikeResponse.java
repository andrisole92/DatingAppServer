package com.dating.server.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Data
@AllArgsConstructor
public class LikeResponse {
    private boolean matched;
}
