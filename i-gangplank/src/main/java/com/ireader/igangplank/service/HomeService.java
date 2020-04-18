package com.ireader.igangplank.service;

import com.ireader.igangplank.hystrix.fallback.HomeServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "CORKI", fallback = HomeServiceHystrix.class)
public interface HomeService {

  @RequestMapping(value = "hi", method = RequestMethod.GET)
  public String sayHi(@RequestParam(value = "message") String message);
}
