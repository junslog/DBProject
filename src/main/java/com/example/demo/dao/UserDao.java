package com.example.demo.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> listForBeanPropertyRowMapper() {
		String query = "SELECT * FROM user";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<User>(User.class));
	}
	
	public int insert(User user) {
		String query = "INSERT INTO user(userNum, userName) VALUES(?,?)";
		return jdbcTemplate.update(query, user.getUserNum(), user.getUserName());
	}
	
}
