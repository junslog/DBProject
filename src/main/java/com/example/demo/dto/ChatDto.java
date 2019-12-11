package com.example.demo.dto;

import java.sql.Timestamp;

public class ChatDto {

	private int no;
	private String sender_id;
	private String receiver_id;
	private String message;
	private Timestamp sent_at;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public String getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getSent_at() {
		return sent_at;
	}
	public void setSent_at(Timestamp sent_at) {
		this.sent_at = sent_at;
	}
	
}
