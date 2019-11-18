package com.epam.dsc2019.cloud.hystrix.client;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class GreetingServiceHystrixImpl implements GreetingService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;

    @Value("${app.external.service.name}")
    private String serviceName;
    @Value("${app.external.fallback.icon}")
    private int iconCode;

    @HystrixCommand(fallbackMethod = "getDefaultGreeting")
    @Override
    public String getGreeting() {
        final Application application = eurekaClient.getApplication(serviceName);
        final InstanceInfo instance = application.getInstances().get(0);
        final String url = "http://" + instance.getHostName() + ":" + instance.getPort() + "/greeting";

        log.info("Ask URL {} for greeting", url);

        return restTemplate.getForObject(url, String.class);
    }

    private String getDefaultGreeting() {
        return new StringBuilder(new String(Character.toChars(iconCode)))
            .append(" ")
            .append("Fallback message!")
            .toString();
    }
}
