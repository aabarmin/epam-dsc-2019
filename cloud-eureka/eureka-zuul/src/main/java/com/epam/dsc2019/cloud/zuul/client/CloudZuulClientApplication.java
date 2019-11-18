package com.epam.dsc2019.cloud.zuul.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class CloudZuulClientApplication {

  /**
   * Start the client application.
   * @param args program arguments
   * @throws Exception in case of interruption
   */
  public static void main(String[] args) throws Exception {
    final RestTemplate restTemplate = new RestTemplate();
    do {
      final String response = restTemplate
          .getForObject("http://localhost:8080/greeting/", String.class);
      log.info(response);
      Thread.sleep(1000);
    } while (true);
  }
}
