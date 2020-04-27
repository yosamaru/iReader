package com.ireader.igangplank.controller;

import com.ireader.igangplank.service.HomeService;
import java.io.IOException;
import java.util.Locale;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @Resource
  private HomeService homeService;

  @RequestMapping(value = "hi", method = RequestMethod.GET)
  public String sayHi(@RequestParam String message) {
    return homeService.sayHi(message);
  }


  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String iReader(final HttpServletRequest httpRequest, final Locale locale,
      final ModelMap model, final HttpSession session) throws IOException {
    final String APPLICATION = "ireader";

    model.put("app", APPLICATION);
    model.put("locale", locale);
    model.put("contextPath", httpRequest.getContextPath());
    return APPLICATION;
  }

}
