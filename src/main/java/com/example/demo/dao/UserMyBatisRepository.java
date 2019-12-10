package com.example.demo.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.*;

@Mapper
@Repository
public interface UserMyBatisRepository {
	@Select("select * from users")
	public List<UserDto> findAll();
	
	@Select("INSERT INTO users(id, password, name, gender, smoking, snoring, active_type, photo_url, registered_at, withdrew_at) "
			+ "VALUES (#{id}, #{password}, #{name}, #{gender}, #{smoking}, #{snoring}, #{active_type}, #{photo_url}, #{registered_at}, #{withdrew_at})")
	public Integer createUser(UserDto userDto);

	@Select("select * from users where 'id' = #{id}")
	public UserDto findUser(String id);
	
	@Select("SELECT * FROM users WHERE `id`=#{login_id} AND `password`=#{password}")
    //UserDto getAccountUser(@Param("login_id") String loginId, @Param("password") byte[] password);
	UserDto getAccountUser(@Param("login_id") String loginId, @Param("password") String password);
}

