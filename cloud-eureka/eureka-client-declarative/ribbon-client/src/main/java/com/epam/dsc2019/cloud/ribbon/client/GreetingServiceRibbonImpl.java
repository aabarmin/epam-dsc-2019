package com.epam.dsc2019.cloud.ribbon.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingServiceRibbonImpl implements GreetingService {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public String getGreeting() {
    return restTemplate.getForObject("http://cloud-eureka-client/greeting", String.class);
  }
}
