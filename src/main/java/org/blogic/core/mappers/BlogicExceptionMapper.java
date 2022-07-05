package org.blogic.core.mappers;

import org.blogic.core.exceptions.BlogicException;
import org.blogic.core.utils.ApiResponseUtils;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BlogicExceptionMapper implements ExceptionMapper<BlogicException> {

    @Override
    public Response toResponse(final BlogicException exception) {
        return ApiResponseUtils.buildResponse(exception);
    }

}
