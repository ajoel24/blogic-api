package org.blogic.core.controllers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.blogic.core.dto.UserDto;
import org.blogic.core.models.response.ResponseType;
import org.blogic.core.services.UserService;
import org.blogic.core.utils.ApiResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@Path("/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(@Valid @RequestBody final UserDto userDto) {
        try {
            final var user = userService.create(userDto);
            if (user != null) {
                return ApiResponseUtils.successResponse(ResponseType.USER_CREATED_SUCCESSFULLY);
            }
        } catch (final Exception exception) {
            LOGGER.error("Error: {}", ExceptionUtils.getStackTrace(exception));
        }

        return ApiResponseUtils.errorResponse(ResponseType.USER_NOT_CREATED);
    }
}
