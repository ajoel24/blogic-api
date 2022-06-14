package org.blogic.core.controllers;

import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@Path("/")
public class BlogicController {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        return Response.ok("Hello world").build();
    }
}
