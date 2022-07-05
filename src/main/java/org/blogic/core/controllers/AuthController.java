package org.blogic.core.controllers;

import org.blogic.core.dto.RegisterUserRequestDto;
import org.blogic.core.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.blogic.core.utils.BlogicConstants.APPLICATION_V1_JSON;

@RestController
@Path("/auth")
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(APPLICATION_V1_JSON)
    public Response registerUser(@Valid @RequestBody final RegisterUserRequestDto dto) {
        return authService.registerUser(dto);
    }
}
