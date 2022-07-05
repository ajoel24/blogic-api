package org.blogic.core.utils;

import org.blogic.core.exceptions.BlogicException;
import org.blogic.core.models.enums.ApiResponseType;
import org.blogic.core.models.response.ApiResponse;

import javax.ws.rs.core.Response;

public final class ApiResponseUtils {
    private ApiResponseUtils() {
    }

    public static Response buildResponse(final ApiResponseType apiResponseType) {
        return Response.status(apiResponseType.getHttpStatus())
                .entity(toApiResponse(apiResponseType))
                .build();
    }

    public static Response buildResponse(final ApiResponseType apiResponseType, final Object data) {
        final var apiResponse = toApiResponse(apiResponseType, data);

        return Response.status(apiResponseType.getHttpStatus())
                .entity(apiResponse)
                .build();
    }

    public static Response buildResponse(final BlogicException exception) {
        final var apiResponse = new ApiResponse(exception.getStatus(), exception.getCode(), exception.getMessage(), exception.getData());

        return Response.status(exception.getHttpStatus())
                .entity(apiResponse)
                .build();
    }

    private static ApiResponse toApiResponse(final ApiResponseType apiResponseType) {
        return new ApiResponse(apiResponseType.getStatus(), apiResponseType.getCode(), apiResponseType.getDescription(), null);
    }

    private static ApiResponse toApiResponse(final ApiResponseType apiResponseType, final Object data) {
        return new ApiResponse(apiResponseType.getStatus(), apiResponseType.getCode(), apiResponseType.getDescription(), data);
    }
}
