package com.epam.dsc2019.cloud.security.client;

import com.google.common.collect.Maps;
import java.util.Map;
import org.springframework.security.core.Authentication;
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
  public ModelAndView secretPage(Authentication authentication, ModelAndView modelAndView) {
    modelAndView.setViewName("secured-page");
    final Map<String, Object> attributes = Maps.newHashMap();
    attributes.put("name", authentication.getName());
    attributes.put("authorities", authentication.getAuthorities());
    modelAndView.addAllObjects(attributes);
    return modelAndView;
  }
}
