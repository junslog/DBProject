package com.example.demo.dto;

import java.sql.Timestamp;

public class CommentDto {
	private int article_no;
	private String author_id;
	private String content;
	private Timestamp posted_at;
	private Timestamp deleted_at;
	
	public CommentDto() {}
	public CommentDto(int article_no, String author_id, String content, Timestamp posted_at, Timestamp deleted_at) {
		super();
		this.article_no = article_no;
		this.author_id = author_id;
		this.content = content;
		this.posted_at = posted_at;
		this.deleted_at = deleted_at;
	}
	public int getArticle_no() {
		return article_no;
	}
	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
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
