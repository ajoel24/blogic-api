package org.blogic.core.config;

import org.blogic.core.controllers.AdminController;
import org.blogic.core.controllers.HealthCheckController;
import org.blogic.core.controllers.UserController;
import org.blogic.core.mappers.BlogicExceptionMapper;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.validation.ValidationFeature;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.ApplicationPath;
import java.time.Duration;
import java.util.Collections;

@ApplicationPath("/blogic")
@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(UserController.class);
        register(AdminController.class);
        register(HealthCheckController.class);

        register(ValidationFeature.class);

        register(BlogicExceptionMapper.class);
    }

    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder) {
        final var requestFactory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        final var log = LoggerFactory.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME);

        return restTemplateBuilder
                .requestFactory(() -> requestFactory)
                .setReadTimeout(Duration.ofMillis(30000))
                .setConnectTimeout(Duration.ofMillis(30000))
                .interceptors(Collections.singleton(((request, body, execution) -> {
                    log.debug("Request: {} | Body: {}", request, body);
                    return execution.execute(request, body);
                })))
                .build();
    }
}
