package com.epam.training.cloud.security.resource.server;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoEndpoint {
    @GetMapping("/user/me")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}
