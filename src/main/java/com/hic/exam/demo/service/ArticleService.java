package com.hic.exam.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hic.exam.demo.Dto.Article;
import com.hic.exam.demo.util.Util;

@Service
public class ArticleService {
	List<Article> articles;
	int articleLastId;

	ArticleService() {
		articles = new ArrayList<>();
		articleLastId = 0;
		makeTestData();
	}

	// writeArticle 함수
	public int writeArticle(String title, String body) {

		int id = articleLastId + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();

		Article article = new Article(id, regDate, updateDate, title, body);
		articles.add(article);

		articleLastId = id;

		return id;

	}

	// modifyArticle 함수
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

	// 게시물 삭제할 번호 찾는 함수
	public boolean getDeleteId(int id) {
		Article article = getArticleId(id);

		if (article == null) {
			return false;
		}
		articles.remove(article);
		return true;

	}

	// 게시물 번호 찾기
	public Article getArticleId(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	public void makeTestData() {
		for (int i = 0; i <= 3; i++) {
			writeArticle("제목1", "내용1");
		}
	}

}
