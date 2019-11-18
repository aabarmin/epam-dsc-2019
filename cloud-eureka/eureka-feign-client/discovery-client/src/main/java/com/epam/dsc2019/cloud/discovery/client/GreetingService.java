package com.epam.dsc2019.cloud.discovery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("cloud-eureka-client")
public interface GreetingService {
    @GetMapping("/greeting")
    String getGreeting();
}
