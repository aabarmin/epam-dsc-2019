package com.epam.dsc2019.basic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class BasicGreetingController {

  @Value("${basic.service.name}")
  private String serviceName;

  @Value("${basic.service.icon}")
  private int iconCode;

  /**
   * Returns the greeting message with icon.
   *
   * @return message string
   */
  @GetMapping
  public String getGreeting() {
    return new StringBuilder(new String(Character.toChars(iconCode)))
        .append(" ")
        .append("Hello from ")
        .append(" ")
        .append(serviceName)
        .toString();
  }
}
