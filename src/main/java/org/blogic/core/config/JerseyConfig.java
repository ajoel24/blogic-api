package org.blogic.core.config;

import org.blogic.core.controllers.BlogicController;
import org.blogic.core.controllers.HealthCheckController;
import org.blogic.core.controllers.UserController;
import org.blogic.core.exception.ValidationExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/blogic")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ValidationExceptionMapper.class);

        register(HealthCheckController.class);
        register(UserController.class);
        register(BlogicController.class);
    }
}
