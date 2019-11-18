package com.epam.dsc2019.cloud.ribbon.client;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@RibbonClients({
    @RibbonClient(
        name = "cloud-eureka-client",
        configuration = RibbonConfiguration.class
    )
})
public class RibbonConfiguration {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule eurekaClientSelectionRule() {
        return new WeightedResponseTimeRule();
    }
}
