package com.example.demo.dto;

public class UserDto {

	private String id;
	private String password;
	public UserDto(String Id, String Password) {
		this.id = Id;
		this.password = Password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
