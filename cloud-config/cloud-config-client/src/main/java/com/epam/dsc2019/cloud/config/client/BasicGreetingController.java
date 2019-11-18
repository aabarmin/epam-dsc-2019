package com.epam.dsc2019.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class BasicGreetingController {

  @Value("${app.service.name}")
  private String serviceName;

  /**
   * Returns a greeting message.
   *
   * @return greeting message
   */
  @GetMapping
  public String getGreeting() {
    return "Hello from " + serviceName;
  }
}
