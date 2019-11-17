package com.epam.training.cloud.discovery.client;

import java.util.List;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingServiceImpl implements GreetingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceImpl.class);
    private static final int MAX_ERRORS_COUNT = 30;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EurekaClient eurekaClient;
    @Value("${app.external.service.name}")
    private String serviceName;


    @Override
    public String getGreeting() throws Exception {
        LOGGER.info("Getting all instances of {} application", serviceName);

        final Application application = eurekaClient.getApplication(serviceName);
        LOGGER.info("Application found: {}", application != null);
        LOGGER.info("Instances count: {}", application.getInstances().size());

        if (application.getInstances().isEmpty()) {
            return "";
        }

        // a very simple fault tolerance, try to load a few times
        final List<InstanceInfo> instances = application.getInstances();
        int errors = 0;
        int currentInstanceIndex = 0;
        while (errors < MAX_ERRORS_COUNT) {
            try {
                if (instances.size() == 0) {
                    throw new RuntimeException("There are no instances of a Greeting Service Running");
                }
                final InstanceInfo instance = instances.get(currentInstanceIndex);
                final String url = "http://" + instance.getHostName() + ":" + instance.getPort() + "/greeting";
                LOGGER.info("Ask URL {} for greeting", url);

                return restTemplate.getForObject(url, String.class);
            } catch (RestClientException e) {
                System.err.println("A Greeting Service is down, wait a second and try to use another one");
                Thread.sleep(1000);
                errors++;
                currentInstanceIndex++;
                if (currentInstanceIndex >= instances.size()) {
                    currentInstanceIndex = 0;
                }
            }
        }
        throw new RuntimeException("Can't get a greeting, the greeting service is down");
    }
}
