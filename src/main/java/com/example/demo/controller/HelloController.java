package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.User;

@Controller
public class HelloController {

	@Autowired
	private UserDao userDao;
	
	@GetMapping("/sqlTest")
	public String SQLtestPage() {
		return "sqlTest";
	}
	
	@PostMapping("sqlTest/user")
	public String userAdd(User user) {
		System.out.print(user);
		userDao.insert(user);
		return "redirect:/sqlTest/user";
	}
		
	@GetMapping("sqlTest/user")
	public String userlistPage(Model model) {
		model.addAttribute("users", userDao.listForBeanPropertyRowMapper());
		return "/userList";
	}
	
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
