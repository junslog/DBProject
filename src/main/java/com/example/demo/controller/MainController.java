package com.example.demo.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;


import com.example.demo.dao.*;
import com.example.demo.dto.*;

@RestController
public class MainController {
	
	//@Autowired
	//private UserService userService;
	@Autowired
	private UserMyBatisRepository userRepository;
	
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
	
	@RequestMapping("/insert")
	public String insert() {
		java.util.Date date = new java.util.Date();
		
		Timestamp temp1 = new Timestamp(date.getTime());
		Timestamp temp2 = new Timestamp(date.getTime());
		UserDto tempUser = new UserDto("id", "password", "name", "MALE", "Y", "Y", "MORNING","212040", temp1, temp2);
		userRepository.createUser(tempUser);
		return "insert";
	}
	
	@RequestMapping("/find")
	public List<UserDto> find() {
		List<UserDto> list = userRepository.findAll();
		System.out.println(list.size());
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println("id : " + list.get(i).getId());
			System.out.println("pw : " + list.get(i).getPassword());
		}
		return list;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody UserDto form) {
		
		
		return "";
	}
	
}
