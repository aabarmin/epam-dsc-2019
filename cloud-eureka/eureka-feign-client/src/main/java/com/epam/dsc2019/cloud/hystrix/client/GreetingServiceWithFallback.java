package com.epam.dsc2019.cloud.hystrix.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "cloud-eureka-client",
        fallback = GreetingServiceWithFallback.GreetingServiceFallback.class
)
public interface GreetingServiceWithFallback {
    @GetMapping("/greeting")
    String getGreeting();

    @Component
    public class GreetingServiceFallback implements GreetingServiceWithFallback {
        @Override
        public String getGreeting() {
            return "Fallback message!";
        }
    }
}
