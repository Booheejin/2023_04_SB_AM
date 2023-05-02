package com.koreaIT.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.koreaIT.demo.vo.Article;
import com.koreaIT.demo.vo.ResultData;

@Mapper
public interface ArticleRepository {
	
	// 서비스 메서드
	
	public void writeArticle(int memberId, int boardId, String title, String body);
	
	public int getLastInsertId();
	
//	@Select("SELECT * FROM article WHERE id = #{id}")
	public Article getArticleById(int id);
	
//	@Select("SELECT * FROM article ORDER BY id DESC")
	public List<Article> getArticles(int boardId, String searchKeywordType, String searchKeyword, int itemsInAPage, int limitStart);

//	@Update("UPDATE article SET updateDate = NOW(), title = #{title}, `body` = #{body} WHERE id = #{id}")
//	public void modifyArticle(int id, String title, String body);
	
//	@Update("""
//			UPDATE article SET 
//			updateDate = NOW(), 
//			title = #{title}, 
//			`body` = #{body} 
//			WHERE id = #{id}
//			""")
	public void modifyArticle(int id, String title, String body);
	
//	@Delete("DELETE FROM article WHERE id = #{id}")
	public void deleteArticle(int id);

	public Article getForPrintArticle(int id, int loginedMemberId);

	public Article getForPrintArticle(int id);

	public int getArticlesCnt(int boardId, String searchKeywordType, String searchKeyword);

	public int getArticlesCount(int id);

	
	
}
