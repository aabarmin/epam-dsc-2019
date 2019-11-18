package com.epam.dsc2019.cloud.hystrix.client;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class CloudEurekaFeignClientWithHystrixApplication {

  /**
   * Start the feign with the fallback client app.
   *
   * @param args app arguments
   * @throws Exception in case of interruption
   */
  public static void main(String[] args) throws Exception {
    final ConfigurableApplicationContext context =
        new SpringApplicationBuilder(CloudEurekaFeignClientWithHystrixApplication.class)
            .web(WebApplicationType.NONE)
            .profiles("secondary")
            .run(args);

    final GreetingServiceWithFallback service = context.getBean(GreetingServiceWithFallback.class);
    do {
      log.info(service.getGreeting());
      Thread.sleep(1000);
    } while (true);
  }
}
