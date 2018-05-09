package com.letiy.kms.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping("/")
	public String index() {
		return "this is the index page";
	}

	@RequestMapping("/user")
	public String getUser() {
		return "Kalen Tang";
	}
	
	@RequestMapping("/users")
	public String getUserList() {
		return "this is user list: zhang,wang";
	}
}
