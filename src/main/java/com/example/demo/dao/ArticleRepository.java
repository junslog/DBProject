package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ArticleDto;
import com.example.demo.dto.CommentDto;


@Mapper
@Repository
public interface ArticleRepository {
	
	@Select("select * from articles limit 10 offset #{page}")
	public List<ArticleDto> getArticle(@Param ("page") int page);
	
	@Select("select count(no) from articles")
	public int getArticleCount();
	
	@Select("insert into articles (board_no, author_id, title, content, posted_at) values (#{board_no}, #{author_id}, #{title}, #{content}, #{posted_at}")
	public Integer insertArticle(ArticleDto boardDto);
	
	@Select("select * from comments where article_no = #{no}")
	public List<CommentDto> getComments(@Param ("no") int no);
	
	@Select("insert into comments (article_no, author_id, content, posted_at) values (#{no}, #{author_id}, #{content}, #{posted_at}")
	public Integer insertComment(CommentDto commentdto);
}
