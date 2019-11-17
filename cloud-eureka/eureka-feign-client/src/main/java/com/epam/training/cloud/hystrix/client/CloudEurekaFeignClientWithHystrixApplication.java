package com.epam.training.cloud.hystrix.client;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@SuppressWarnings({"Duplicates", "InfiniteLoopStatement"})
public class CloudEurekaFeignClientWithHystrixApplication {
    public static void main(String[] args) throws Exception {
        final ConfigurableApplicationContext context =
                new SpringApplicationBuilder(CloudEurekaFeignClientWithHystrixApplication.class)
                        .web(WebApplicationType.NONE)
                        .profiles("secondary")
                        .run(args);

        final GreetingServiceWithFallback service = context.getBean(GreetingServiceWithFallback.class);
        do {
            System.out.println(service.getGreeting());
            Thread.sleep(1000);
        } while (true);
    }
}
