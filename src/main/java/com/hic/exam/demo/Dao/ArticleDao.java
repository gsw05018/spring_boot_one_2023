//다시 git에 옮깁니다
package com.hic.exam.demo.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hic.exam.demo.Dto.Article;

@Mapper
public interface ArticleDao {


	
	void writeArticle(@Param("memberId")int memberId, @Param("boardId")int boardId,@Param("title")String title, @Param("body")String body) ;
	
	boolean modifyArticle(@Param("id")int id, @Param("title")String title, @Param("body")String body) ;
	
	void deleteArticleById(@Param("id")int id) ;
	
	Article getArticleId(@Param("id")int id) ;
	
	@Select("SELECT * FROM article")
	List<Article> getArticles() ;
	
	int getLastInsertId();
}
