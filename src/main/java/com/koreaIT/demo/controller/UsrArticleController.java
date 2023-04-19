package com.koreaIT.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.demo.service.ArticleService;
import com.koreaIT.demo.util.Util;
import com.koreaIT.demo.vo.Article;
import com.koreaIT.demo.vo.ResultData;

@Controller
public class UsrArticleController {
	
	private ArticleService articleService;
	
	@Autowired
	public UsrArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
//	액션 메서드
	@RequestMapping("/usr/article/doadd")
	@ResponseBody
	public ResultData doAdd(String title,String body) {
		
		if(Util.empty(title)) {
			return ResultData.from("F-1","제목를 입력해 주세요");

		}
		if(Util.empty(body)) {
			return ResultData.from("F-1","내용을 입력해 주세요");

		}
		
		articleService.writeArticle(title, body);
		
		int id = articleService.getLastInsertId();
		
		Article article = articleService.getArticleById(id);
		
		
		return ResultData.from("S-1",Util.f("%d번 게시물을 생성되었습니다.",id),article);
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		
		return articleService.getArticles();
	}
	
	@RequestMapping("/usr/article/dodelete")
	@ResponseBody
	public String doDelete(int id) {
		
		Article article = articleService.getArticleById(id);
		
		
		if(article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}
		
		articleService.deleteArticle(id);
		
		return id +"번 게시물을 삭제했습니다.";
	}
	
	@RequestMapping("/usr/article/domodify")
	@ResponseBody
	public String doModify(int id , String title , String body) {
		
		Article article = articleService.getArticleById(id);
		
		if(article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}
		
		articleService.modifyArticle(id,title,body);
		
		return id +"번 게시물을 수정했습니다.";
	}
	
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData getArticle(int id) {
		
		Article article = articleService.getArticleById(id);
		
		if(article == null) {
			return ResultData.from("F-1", Util.f("%d번 게시물은 존재하지 않습니다.", id));
		}
		
		return ResultData.from("S-1", Util.f("%d번 게시물 입니다.", id),article);
	}

}



