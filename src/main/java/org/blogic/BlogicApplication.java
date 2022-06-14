package org.blogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.blogic.*")
public class BlogicApplication {

    public static void main(final String[] args) {
        SpringApplication.run(BlogicApplication.class, args);
    }

}