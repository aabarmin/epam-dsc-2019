package com.epam.dsc2019.cloud.discovery.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class CloudConfigServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudConfigServerApplication.class);
  }
}
