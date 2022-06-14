package org.blogic.core.controllers;

import org.blogic.core.models.response.ResponseStatus;
import org.blogic.core.utils.ApiResponseUtils;
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response live() {
        return ApiResponseUtils.basicResponse(ResponseStatus.SUCCESS, appName + " is running", Response.Status.OK);
    }
}
