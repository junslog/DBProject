package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "form";
	}
	
	@RequestMapping("/authentication")
	public String auth() {
		return "authentication";
	}
	
	@RequestMapping("/welcome")
	public String welcome(@RequestParam("id") String id, Model model) {
		model.addAttribute("id", id);
		return "welcome";
	}
}
