package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ChatDto;


@Mapper
@Repository
public interface ConversationMyBatisRepository {
	
	@Select("SELECT * FROM chats WHERE "
			+ "(sender_id = #{sender_id} AND receiver_id = #{receiver_id})"
			+ "OR (sender_id = #{receiver_id} AND receiver_id = #{sender_id})")
	public List<ChatDto> getChatsBetweenTwoUsers(@Param("sender_id")String sender_id, @Param("receiver_id") String receiver_id);

	@Insert("INSERT INTO chats(no, sender_id, receiver_id, message, sent_at"
			+ "VALUES(#{id}, #{sender_id},#{receiver_id}, #{message}, #{sent_at}")
	public void insertChatInDB(ChatDto chatDto);
	
}
