package com.epam.training.cloud.discovery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("cloud-eureka-client")
public interface GreetingService {
    @GetMapping("/greeting")
    String getGreeting();
}
