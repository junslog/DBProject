package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ConversationMyBatisRepository;
import com.example.demo.dto.ChatDto;
import com.example.demo.dto.UserDto;
import com.example.demo.form.ReqForConversationForm;

@Service
public class ConversationService {

	@Autowired
	ConversationMyBatisRepository conversationRepository;
	
	@Autowired
	UserService userService;
	
	public List<ChatDto> getChatsBetweenTwoUsers(ReqForConversationForm rfcForm){
		System.out.println("JWT Token Value : " + rfcForm.getJwtToken());
		UserDto sender = userService.getUserByToken(rfcForm.getJwtToken());
		String sender_id = sender.getId();
		String receiver_id = rfcForm.getId();
		return conversationRepository.getChatsBetweenTwoUsers(sender_id, receiver_id);
	}
	
	
}
