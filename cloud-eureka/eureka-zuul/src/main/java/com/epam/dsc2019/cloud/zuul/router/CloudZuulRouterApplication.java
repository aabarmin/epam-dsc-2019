package com.epam.dsc2019.cloud.zuul.router;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class CloudZuulRouterApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(CloudZuulRouterApplication.class);
  }
}
