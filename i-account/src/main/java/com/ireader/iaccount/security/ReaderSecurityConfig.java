package com.ireader.iaccount.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.PrintWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 负责程序中所有的安全性
 */
@Configuration
@EnableWebSecurity
// 开启方法权限管理
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ReaderSecurityConfig extends WebSecurityConfigurerAdapter {

	Logger logger = LoggerFactory.getLogger(ReaderSecurityConfig.class);

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// 所有请求身份验证
//		httpSecurity.httpBasic().and().authorizeRequests().anyRequest().authenticated();
		httpSecurity.csrf().disable().formLogin().loginPage("/login").loginProcessingUrl("/auth/login")
				.successHandler((request, response, authentication) -> {
					response.setContentType("application/json;charset=utf-8");
					PrintWriter writer = response.getWriter();
					ObjectMapper om = new ObjectMapper();
					String successMsg = om.writeValueAsString(om.writeValueAsString(authentication));
					writer.write(successMsg);
					writer.flush();
					writer.close();
				})
				.failureHandler((request, response, exception) -> {
					response.setContentType("application/json;charset=utf-8");
					PrintWriter writer = response.getWriter();
					writer.write(new ObjectMapper().writeValueAsString(exception));
					writer.flush();
					writer.close();
				})
				.and().authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated();
	}
}
