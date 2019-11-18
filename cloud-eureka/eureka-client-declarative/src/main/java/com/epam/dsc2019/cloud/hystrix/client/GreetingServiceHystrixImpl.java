package com.epam.dsc2019.cloud.hystrix.client;

import com.epam.dsc2019.cloud.discovery.client.GreetingService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingServiceHystrixImpl implements GreetingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceHystrixImpl.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
    @Value("${app.external.service.name}")
    private String serviceName;

    @HystrixCommand(fallbackMethod = "getDefaultGreeting")
    @Override
    public String getGreeting() throws Exception {
        final Application application = eurekaClient.getApplication(serviceName);
        final InstanceInfo instance = application.getInstances().get(0);
        final String url = "http://" + instance.getHostName() + ":" + instance.getPort() + "/greeting";
        LOGGER.info("Ask URL {} for greeting", url);

        return restTemplate.getForObject(url, String.class);
    }

    private String getDefaultGreeting() {
        return "Fallback message!";
    }
}
