package com.epam.training.cloud.zuul.client;

import org.springframework.web.client.RestTemplate;

public class CloudZuulClientApplication {
    public static void main(String[] args) throws Exception {
        do {
            final String response = new RestTemplate().getForObject("http://localhost:8080/greeting/", String.class);
            System.out.println(response);
            Thread.sleep(1000);
        } while (true);
    }
}
