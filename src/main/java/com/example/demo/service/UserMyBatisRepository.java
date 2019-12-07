package com.example.demo.dao;



import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.example.demo.dto.*;

public interface UserMyBatisRepository {
	@Select("select * from usertable")
	public List<UserDto> findAll();
	
	@Select("INSERT INTO usertable(id, password) VALUES(#(id),#(password))")
	public int insert(UserDto userDto);
	
	
}
