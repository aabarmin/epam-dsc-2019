package com.epam.dsc2019.basic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class BasicGreetingController {
    @Value("${basic.service.name}")
    private String serviceName;

    @GetMapping
    public String getGreeting() {
        return "Hello from " + serviceName;
    }
}
