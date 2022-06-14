package org.blogic.core.exception;

import org.apache.commons.lang3.StringUtils;
import org.blogic.core.models.response.ResponseType;
import org.blogic.core.utils.ApiResponseUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.stream.StreamSupport;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        final var violations = exception.getConstraintViolations().stream()
                .map(this::prepareViolationDetails)
                .toList();

        return ApiResponseUtils.failureResponse(ResponseType.VALIDATION_FAILED, violations);
    }

    private Map<String, Object> prepareViolationDetails(final ConstraintViolation<?> violation) {
        final var property = StreamSupport.stream(violation.getPropertyPath().spliterator(), false)
                .map(Path.Node::getName)
                .reduce((first, second) -> second)
                .orElse(StringUtils.EMPTY);

        return Collections.singletonMap(property, violation.getMessage());
    }
}
