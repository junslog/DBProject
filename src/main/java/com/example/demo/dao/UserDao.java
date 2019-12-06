package com.example.demo.dao;


import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto;




@Repository
public class UserDao {

	// jdbcTemplate 사용법을 익혀야 함.
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<UserDto> listForBeanPropertyRowMapper() {
		String query = "SELECT * FROM user";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<UserDto>(UserDto.class));
	}
	
	// jdbcTemplate.update 메서드를 통해 Read를 제외한 나머지 Insert/Update/Delete를 구현할 수 있다.
	public int insert(UserDto user) {
		String query = "INSERT INTO user(id, pw) VALUES(?,?)";
		return jdbcTemplate.update(query, user.getId(), user.getPassword());
	}
	
	// jdbcTemplate.queryForObject에서 SELECT문을 쓸 수 있다.
	public UserDto retrieveUserById(String id) {
		String sql = "SELECT * FROM user WHERE id = ?";	// ? 를 통한 변수 바인딩
		UserDto userDto = jdbcTemplate.queryForObject(	// Record를 매핑하기 위해 jdbcTemplate.queryForObject API 사용
				sql, 
				new Object[] {id},
				new RowMapper<UserDto>() {
					public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserDto userDto = new UserDto();
						
						userDto.setId(rs.getString("id"));
						userDto.setPassword(rs.getString("pw"));
						
						return userDto;
					}
				});
		return userDto;
	}
	
	
	
}
