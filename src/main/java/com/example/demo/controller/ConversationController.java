package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChatDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.UnauthorizedException;
import com.example.demo.form.ReqForConversationForm;
import com.example.demo.service.ConversationService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

	@Autowired
	ConversationService service;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/{id}")
	public List<ChatDto> getChatsBetweenTwoUsers(@RequestBody ReqForConversationForm rfcForm) {
		System.out.println("Receiver ID : " + rfcForm.getId());
		return service.getChatsBetweenTwoUsers(rfcForm);
	}
	
	@PostMapping("/insert")
	public void InsertChatInDB(@RequestHeader(value="jwtToken") String jwtToken, @RequestBody ChatDto chatDto) {
		UserDto userDto = userService.getUserByToken(jwtToken);
		
		if(userDto.getId() != chatDto.getSender_id())
			throw new UnauthorizedException();
		
		service.insertChatInDB(chatDto);
	}
	
}
