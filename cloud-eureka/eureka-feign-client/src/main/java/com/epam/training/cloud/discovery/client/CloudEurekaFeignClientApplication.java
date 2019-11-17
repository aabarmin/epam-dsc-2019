package com.epam.training.cloud.discovery.client;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@SuppressWarnings({"Duplicates", "InfiniteLoopStatement"})
public class CloudEurekaFeignClientApplication {
    public static void main(String[] args) throws Exception {
        final ConfigurableApplicationContext context = new SpringApplicationBuilder(CloudEurekaFeignClientApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        final GreetingService greetingService = context.getBean(GreetingService.class);

        do {
            System.out.println(greetingService.getGreeting());
            Thread.sleep(1000);
        } while (true);
    }
}
