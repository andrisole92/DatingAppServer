package com.dating.server.payload.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserSearchRequest {
    @Length(min = 2, max = 2)
    private int[] age = {18,99};
}
