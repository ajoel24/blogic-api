package org.blogic.core.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.blogic.core.models.enums.ApiErrorCode;
import org.blogic.core.models.enums.ApiStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse(
        ApiStatus status,
        ApiErrorCode code,
        String message,
        Object data
) {
}
