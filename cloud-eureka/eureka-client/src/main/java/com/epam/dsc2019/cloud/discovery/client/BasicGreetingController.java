package com.epam.dsc2019.cloud.discovery.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class BasicGreetingController {
    @Value("${app.service.name}")
    private String serviceName;

    @GetMapping
    public String getGreeting() {
        return "Hello from " + serviceName;
    }

    @GetMapping("/{value}")
    public String getGreeting(@PathVariable("value") String value) {
        return "Hello from " + serviceName + ", " + value;
    }
}
