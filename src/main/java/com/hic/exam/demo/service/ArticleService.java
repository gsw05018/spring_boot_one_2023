package com.hic.exam.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hic.exam.demo.Dao.ArticleDao;
import com.hic.exam.demo.Dto.Article;
import com.hic.exam.demo.Dto.ResultData;

@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;
	public List<Article> articles;

	// write 함수
	public ResultData writeArticle(String title, String body) {

		int id = articleDao.writeArticle(title, body);

		return new ResultData("F-1", id + "번 게시물이 작성되었습니다", "id", id);
	}

	// modify
	public ResultData modifyArticle(int id, String title, String body) {

		Article article = getArticleId(id);
		if (article == null) {
			return new ResultData("S-1", id + "번이 존재하지 않습니다", "id", id);
		}
		articleDao.modifyArticle(id, title, body);

		return new ResultData("F-1", id + "번 글이 수정되었습니다", "id", id);
	}

	//delete
	public ResultData deleteArticleById(int id) {

		Article article = getArticleId(id);
		if (article == null) {
			return new ResultData("S-1", id + "번이 존재하지 않습니다", "id", id);
		}
		articleDao.deleteArticleById(id);
		return new ResultData("F-1", id + "번이 삭제되었습니다", "id", id);

	}

	// detail
	public Article getArticleId(int id) {
		return articleDao.getArticleId(id);

	}

	public List<Article> getArticles() {
		return articleDao.getArticles();
	}

	
}
