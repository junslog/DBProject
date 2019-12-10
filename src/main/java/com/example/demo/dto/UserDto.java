package com.example.demo.dto;

import java.sql.Timestamp;

public class UserDto {

	private String id;
	private String password;
	private String name;
	private String gender;	
	private String smoking;
	private String snoring;
	private String active_type;
	private String photo_url;
	private Timestamp registered_at;
	private Timestamp withdrew_at;
	public UserDto(String id, String password, String name, String gender, String smoking, String snoring,
			String active_type, String photo_url, Timestamp registered_at, Timestamp withdrew_at) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.smoking = smoking;
		this.snoring = snoring;
		this.active_type = active_type;
		this.photo_url = photo_url;
		this.registered_at = registered_at;
		this.withdrew_at = withdrew_at;
	}
	public UserDto() {}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String getSnoring() {
		return snoring;
	}
	public void setSnoring(String snoring) {
		this.snoring = snoring;
	}
	public String getActive_type() {
		return active_type;
	}
	public void setActive_type(String active_type) {
		this.active_type = active_type;
	}
	public String getPhoto_url() {
		return photo_url;
	}
	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}
	public Timestamp getRegistered_at() {
		return registered_at;
	}
	public void setRegistered_at(Timestamp registered_at) {
		this.registered_at = registered_at;
	}
	public Timestamp getWithdrew_at() {
		return withdrew_at;
	}
	public void setWithdrew_at(Timestamp withdrew_at) {
		this.withdrew_at = withdrew_at;
	}
}
	
	
	