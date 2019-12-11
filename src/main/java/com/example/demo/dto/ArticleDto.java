package com.example.demo.dto;

import java.sql.Timestamp;

public class ArticleDto {
	private int board_no;
	private String author_id;
	private String title;
	private String content;
	private Timestamp posted_at;
	private Timestamp deleted_at;
	
	public ArticleDto() {}
	public ArticleDto(int board_no, String author_id, String title, String content, Timestamp posted_at,
			Timestamp deleted_at) {
		super();
		this.board_no = board_no;
		this.author_id = author_id;
		this.title = title;
		this.content = content;
		this.posted_at = posted_at;
		this.deleted_at = deleted_at;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getPosted_at() {
		return posted_at;
	}
	public void setPosted_at(Timestamp posted_at) {
		this.posted_at = posted_at;
	}
	public Timestamp getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}
	
	
}
