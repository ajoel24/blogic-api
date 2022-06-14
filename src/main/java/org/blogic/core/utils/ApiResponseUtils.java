package org.blogic.core.utils;

import org.blogic.core.models.response.ApiResponse;
import org.blogic.core.models.response.ResponseStatus;
import org.blogic.core.models.response.ResponseType;

import javax.ws.rs.core.Response;

public final class ApiResponseUtils {
    private ApiResponseUtils() {
        // This will be empty
    }

    public static Response successResponse(final ResponseType responseCode) {
        final ApiResponse apiResponse = new ApiResponse(ResponseStatus.SUCCESS.toString()
                .toLowerCase(), responseCode.getMessage(), null);

        return buildResponse(responseCode.getHttpStatus(), apiResponse);
    }

    public static Response successResponse(final ResponseType responseCode, final Object data) {
        final ApiResponse apiResponse = new ApiResponse(ResponseStatus.SUCCESS.toString()
                .toLowerCase(), responseCode.getMessage(), data);

        return buildResponse(responseCode.getHttpStatus(), apiResponse);
    }

    public static Response failureResponse(final ResponseType responseCode) {
        final ApiResponse apiResponse = new ApiResponse(ResponseStatus.FAILURE.toString()
                .toLowerCase(), responseCode.getMessage(), null);

        return buildResponse(responseCode.getHttpStatus(), apiResponse);
    }

    public static Response failureResponse(final ResponseType responseCode, final Object data) {
        final ApiResponse apiResponse = new ApiResponse(ResponseStatus.FAILURE.toString()
                .toLowerCase(), responseCode.getMessage(), data);

        return buildResponse(responseCode.getHttpStatus(), apiResponse);
    }

    public static Response errorResponse(final ResponseType responseCode) {
        final ApiResponse apiResponse = new ApiResponse(ResponseStatus.ERROR.toString()
                .toLowerCase(), responseCode.getMessage(), null);

        return buildResponse(responseCode.getHttpStatus(), apiResponse);
    }

    public static Response errorResponse(final ResponseType responseCode, final Object data) {
        final ApiResponse apiResponse = new ApiResponse(ResponseStatus.ERROR.toString()
                .toLowerCase(), responseCode.getMessage(), data);

        return buildResponse(responseCode.getHttpStatus(), apiResponse);
    }

    public static Response basicResponse(final ResponseStatus responseStatus, final String message, final Response.Status httpStatus) {
        final ApiResponse response = new ApiResponse(responseStatus.toString().toLowerCase(), message, null);

        return Response.status(httpStatus)
                .entity(response)
                .build();
    }

    private static Response buildResponse(final Response.Status status, final ApiResponse response) {
        return Response.status(status)
                .entity(response)
                .build();
    }
}
