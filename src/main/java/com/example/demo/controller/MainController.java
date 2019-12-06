package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index() {
		return "form";
	}
	
	@RequestMapping("/authentication")
	public String auth() {
		return "authentication";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
}
