package com.ireader.ikalista.security;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

//  @Override
//  protected void configure(HttpSecurity httpSecurity) throws Exception {
//    httpSecurity.csrf().disable();
//    super.configure(httpSecurity);
//  }
}
