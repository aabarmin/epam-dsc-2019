package com.epam.dsc2019.cloud.discovery.client;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class CloudEurekaFeignClientApplication {

  /**
   * Start the feign client app.
   *
   * @param args app arguments
   * @throws Exception in case of interruption
   */
  public static void main(String[] args) throws Exception {
    final ConfigurableApplicationContext context = new SpringApplicationBuilder(
        CloudEurekaFeignClientApplication.class)
        .web(WebApplicationType.NONE)
        .run(args);
    final GreetingService greetingService = context.getBean(GreetingService.class);

    do {
      log.info(greetingService.getGreeting());
      Thread.sleep(1000);
    } while (true);
  }
}
