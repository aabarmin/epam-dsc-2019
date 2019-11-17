package com.epam.training.cloud.security.resource.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class CloudResourceServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudResourceServerApplication.class);
    }
}
