package com.dating.server.payload.response;

/**
 * Created by rajeevkumarsingh on 19/08/17.
 */
public class ApiResponse {
    private Boolean success;
    private Object message;

    public ApiResponse(Boolean success, Object message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
