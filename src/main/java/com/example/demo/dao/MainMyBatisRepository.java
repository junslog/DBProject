package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ChatDto;
import com.example.demo.dto.UserDto;


@Mapper
@Repository
public interface MainMyBatisRepository {

	@Select("SELECT * FROM users ORDER BY id DESC "
			+ "LIMIT 30")	// Main Page 접속 시, 30명의 정보를 가져온다.
	public List<UserDto> getUsersForMainPage();
	
	
	@Select("SELECT * FROM chats WHERE "
			+ "(sender_id = #{sender_id} AND receiver_id = #{receiver_id})"
			+ "OR (sender_id = #{receiver_id} AND receiver_id = #{sender_id})")
	public List<ChatDto> getChatsBetweenTwoUsers(@Param("sender_id")String sender_id, @Param("receiver_id") String receiver_id);
	
}
