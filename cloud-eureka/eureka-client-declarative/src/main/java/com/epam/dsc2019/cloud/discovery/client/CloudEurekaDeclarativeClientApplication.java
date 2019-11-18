package com.epam.dsc2019.cloud.discovery.client;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@SuppressWarnings({"Duplicates", "InfiniteLoopStatement"})
public class CloudEurekaDeclarativeClientApplication {
    public static void main(String[] args) throws Exception {
        final ConfigurableApplicationContext context = new SpringApplicationBuilder(CloudEurekaDeclarativeClientApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        final GreetingService greetingService = context.getBean(GreetingService.class);

        do {
            System.out.println(greetingService.getGreeting());
            Thread.sleep(1000);
        } while (true);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
