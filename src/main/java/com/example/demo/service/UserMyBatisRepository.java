package com.example.demo.service;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.*;

@Mapper
@Repository
public interface UserMyBatisRepository {
	@Select("select * from users")
	public List<UserDto> findAll();
	
	@Select("INSERT INTO users(id, password, name, gender, smoking, snoring, active_type, photo_url, registered_at, withdrew_at) "
			+ "VALUES (#{id}, #{password}, #{name}, #{gender}, #{smoking}, #{snoring}, #{active_type}, #{photo_url}, #{registered_at}, #{withdrew_at})")
	public Integer insert(UserDto userDto);

	
}
