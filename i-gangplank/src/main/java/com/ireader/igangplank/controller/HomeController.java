package com.ireader.igangplank.controller;

import com.ireader.igangplank.service.HomeService;
import javax.annotation.Resource;
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

}
