package org.blogic.core.models.enums;

import javax.ws.rs.core.Response;

public enum ApiResponseType {
    USER_ALREADY_EXISTS(ApiStatus.FAIL, ApiErrorCode.INVALID_REQUEST, "User already exists", Response.Status.BAD_REQUEST);

    private final ApiStatus status;
    private final ApiErrorCode code;
    private final String description;
    private final Response.Status httpStatus;

    ApiResponseType(final ApiStatus status, final ApiErrorCode code, final String description, final Response.Status httpStatus) {
        this.status = status;
        this.code = code;
        this.description = description;
        this.httpStatus = httpStatus;
    }

    public ApiStatus getStatus() {
        return status;
    }

    public ApiErrorCode getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Response.Status getHttpStatus() {
        return httpStatus;
    }
}
