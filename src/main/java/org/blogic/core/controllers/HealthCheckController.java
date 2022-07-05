package org.blogic.core.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
@Path("/health")
public class HealthCheckController {
    @Value("${app.name}")
    private String appName;

    @GET
    @Path("/live")
    @Produces(MediaType.TEXT_PLAIN)
    public Response liveProbe() {
        return Response.ok(appName + " is running").build();
    }
}
