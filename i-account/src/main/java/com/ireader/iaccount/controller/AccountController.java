package com.ireader.iaccount.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@GetMapping("login/")
	public String login() {
		return "login";
	}

	@GetMapping("index")
	public String home() {
		return "index";
	}

	@GetMapping("info/")
	public String getCurrentUser(Authentication authentication) {
		return authentication.getName();
	}
}