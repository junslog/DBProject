package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ArticleDto;
import com.example.demo.dto.CommentDto;
import com.example.demo.service.ArticleService;

@RestController
public class ArticleController {

	@Autowired
	private ArticleService Articleservice;
	
	@RequestMapping("/board/{page}")
	public List<ArticleDto> Article(@PathVariable int page){
		return Articleservice.getBoard(page);
	}
	
	@RequestMapping("/board/insert")
		public Integer insertArticle(@RequestBody ArticleDto articleDto, @RequestBody String jwt) {
			return Articleservice.insertArticle(articleDto, jwt);
	}
	
	@GetMapping("/article/{no}")
	public List<CommentDto> comment(@PathVariable int no){
		return Articleservice.getComments(no);
	}
	
	@PostMapping("/article/{no}")
		public Integer insertComment(@RequestBody CommentDto commnetdto, @RequestBody String jwt) {
			return Articleservice.insertComment(commnetdto, jwt);
	}
	
}
