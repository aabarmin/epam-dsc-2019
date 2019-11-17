package com.epam.training.basic;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicApplicationTest {
    @LocalServerPort
    private int localPort;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void basicGreetingTest() {
        assertTrue(restTemplate.getForObject("http://localhost:" + localPort + "/greeting", String.class).contains("Hello from"));
    }
}
