package com.epam.dsc2019.cloud.ribbon.client;

import com.epam.dsc2019.cloud.discovery.client.GreetingService;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RibbonClient(
        name = "cloud-eureka-client",
        configuration = RibbonConfiguration.class
)
public class GreetingServiceRibbonImpl implements GreetingService {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public String getGreeting() throws Exception {
        return this.restTemplate().getForObject("http://cloud-eureka-client/greeting", String.class);
    }
}
