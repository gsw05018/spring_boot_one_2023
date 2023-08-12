//다시 git에 옮깁니다
package com.hic.exam.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hic.exam.demo.Dto.Article;
import com.hic.exam.demo.util.Util;

@Component
public class ArticleDao {

	List<Article> articles;
	int articleLastId;

	ArticleDao() {
		articles = new ArrayList<>();
		articleLastId = 0;
		makeTestData();
	}

	public void makeTestData() {
		for (int i = 0; i <= 3; i++) {
			writeArticle("제목1", "내용1");
		}
	}

	public int writeArticle(String title, String body) {

		int id = articleLastId + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();

		Article article = new Article(id, regDate, updateDate, title, body);
		articles.add(article);

		articleLastId = id;

		return id;

	}

	public boolean modifyArticle(int id, String title, String body) {

		Article article = getArticleId(id);

		if (article == null) {
			return false;

		}

		article.setTitle(title);
		article.setBody(body);
		article.setUpdateDate(Util.getNowDateStr());
		return true;

	}

	public void deleteArticleById(int id) {

		Article article = getArticleId(id);


		articles.remove(article);
		

	}

	public Article getArticleId(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	public List<Article> getArticles() {
		return articles;
		
	}
}
