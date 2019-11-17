package com.epam.training.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class BasicGreetingController {
    private ApplicationConfiguration configuration;

    @GetMapping
    public String getGreeting() {
        return "Hello from " + configuration.getName();
    }

    @Autowired
    public void setConfiguration(ApplicationConfiguration configuration) {
        this.configuration = configuration;
    }
}
