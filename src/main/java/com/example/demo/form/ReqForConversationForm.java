package com.example.demo.form;

public class ReqForConversationForm {

	private String jwtToken;	// 대화를 요청한 사람 ( = 사용자 )의 ID Token
	private String id;	// 사용자가 대화하기를 요청한 사람의  ID
	
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
