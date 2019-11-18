package com.epam.dsc2019.cloud.security.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlPageController {
    @GetMapping("/")
    public ModelAndView indexPage() {
        return new ModelAndView("index");
    }

    @GetMapping("/securedPage")
    public ModelAndView secretPage() {
        return new ModelAndView("secured-page");
    }
}
