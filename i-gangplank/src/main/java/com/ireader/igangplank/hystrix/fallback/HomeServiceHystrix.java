package com.ireader.igangplank.hystrix.fallback;

import com.ireader.igangplank.service.HomeService;
import org.springframework.stereotype.Component;

@Component
public class HomeServiceHystrix implements HomeService {

  @Override
  public String sayHi(String message) {
    return "Hi，your message is :\"" + message + "\" but request error.";
  }
}
