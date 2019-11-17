package com.epam.training.cloud.ribbon.client;

import com.epam.training.cloud.discovery.client.GreetingService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
@SuppressWarnings({"Duplicates", "InfiniteLoopStatement"})
public class CloudEurekaDeclarativeClientWithRibbonApplication {
    public static void main(String[] args) throws Exception {
        final ConfigurableApplicationContext context = new SpringApplicationBuilder(CloudEurekaDeclarativeClientWithRibbonApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        final GreetingService service = context.getBean(GreetingService.class);

        do {
            System.out.println(service.getGreeting());
            Thread.sleep(1000);
        } while (true);
    }
}
