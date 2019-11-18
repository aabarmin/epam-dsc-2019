package com.epam.dsc2019.cloud.ribbon.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
@SuppressWarnings({"Duplicates", "InfiniteLoopStatement"})
@Slf4j
public class CloudEurekaDeclarativeClientWithRibbonApplication {

  /**
   * Start the declarative client with ribbon app.
   *
   * @param args app arguments
   * @throws Exception in case of interruption
   */
  public static void main(String[] args) throws Exception {
    final ConfigurableApplicationContext context = new SpringApplicationBuilder(
        CloudEurekaDeclarativeClientWithRibbonApplication.class)
        .web(WebApplicationType.NONE)
        .run(args);

    final GreetingService service = context.getBean(GreetingService.class);

    do {
      log.info(service.getGreeting());
      Thread.sleep(1000);
    } while (true);
  }
}
