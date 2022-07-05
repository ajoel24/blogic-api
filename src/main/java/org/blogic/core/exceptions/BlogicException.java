package org.blogic.core.exceptions;

import org.blogic.core.models.enums.ApiErrorCode;
import org.blogic.core.models.enums.ApiResponseType;
import org.blogic.core.models.enums.ApiStatus;

import javax.ws.rs.core.Response;
import java.io.Serial;

public class BlogicException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -8743309109191017348L;

    private final String message;
    private final ApiStatus status;
    private final ApiErrorCode code;
    private final Response.Status httpStatus;
    private transient final Object data;

    public BlogicException(final ApiResponseType apiResponseType) {
        super(apiResponseType.getDescription());
        this.message = apiResponseType.getDescription();
        this.code = apiResponseType.getCode();
        this.httpStatus = apiResponseType.getHttpStatus();
        this.status = apiResponseType.getStatus();
        this.data = null;
    }

    public BlogicException(final ApiResponseType apiResponseType, final Object data) {
        super(apiResponseType.getDescription());
        this.message = apiResponseType.getDescription();
        this.code = apiResponseType.getCode();
        this.httpStatus = apiResponseType.getHttpStatus();
        this.status = apiResponseType.getStatus();
        this.data = data;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ApiStatus getStatus() {
        return status;
    }

    public ApiErrorCode getCode() {
        return code;
    }

    public Response.Status getHttpStatus() {
        return httpStatus;
    }

    public Object getData() {
        return data;
    }
}
