package org.blogic.core.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public record ApiResponse(
        String status,
        String message,
        @JsonInclude(JsonInclude.Include.NON_NULL) Object data
) {
}
