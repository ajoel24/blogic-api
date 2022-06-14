package org.blogic.core.models.response;

import javax.ws.rs.core.Response.Status;

import static javax.ws.rs.core.Response.Status.*;

public enum ResponseType {
    USER_CREATED_SUCCESSFULLY("User created successfully", OK),
    USER_NOT_CREATED("Unable to create user", INTERNAL_SERVER_ERROR),
    VALIDATION_FAILED("Validation errors found", BAD_REQUEST);

    private final String message;
    private final Status httpStatus;

    ResponseType(final String message, final Status httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Status getHttpStatus() {
        return httpStatus;
    }
}
