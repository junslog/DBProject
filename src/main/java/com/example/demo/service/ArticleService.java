package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.dto.ArticleDto;
import com.example.demo.dto.CommentDto;
import com.example.demo.dto.UserDto;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository Articlerepository;
	
	@Autowired
	private UserService userService;
	
	
	
	public int getArticleCount() {
		return Articlerepository.getArticleCount();
	}
	
	public List<ArticleDto> getBoard(int page) {
		return Articlerepository.getArticle((page-1) * 10);
	}

	public List<CommentDto> getComments(int no) {
		// TODO Auto-generated method stub
		return Articlerepository.getComments(no);
	}
	
	public Integer insertComment(CommentDto commentdto, String jwt) {
		UserDto userDto = userService.getUserByToken(jwt);
		String id = userDto.getId();
		commentdto.setAuthor_id(id);
		return Articlerepository.insertComment(commentdto);
	}
	
	public Integer insertArticle(ArticleDto articleDto, String jwt) {
		UserDto userDto = userService.getUserByToken(jwt);
		String id = userDto.getId();
		articleDto.setAuthor_id(id);
		return Articlerepository.insertArticle(articleDto);
	}

}
