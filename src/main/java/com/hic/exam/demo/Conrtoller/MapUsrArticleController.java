package com.hic.exam.demo.Conrtoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hic.exam.demo.Dto.Article;
import com.hic.exam.demo.Dto.ResulData;
import com.hic.exam.demo.util.Util;

@Controller
public class MapUsrArticleController {
	List<Article> articles;
	int articleLastId;

	MapUsrArticleController() {
		articles = new ArrayList<>();
		articleLastId = 0;
	}

	@RequestMapping("/mapUsr/article/doWrite")
	@ResponseBody
	public ResulData doWrite(String title, String body) {
		int id = WriteArticle(title, body);
		Article article = getArticleId(id);
		return new ResulData("S-1", id + "번 글이 생성되었습니다", "aritcle", article);

	}

	private int WriteArticle(String title, String body) {

		int id = articleLastId + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();

		Article article = new Article(id, regDate, updateDate, title, body);
		articles.add(article);

		articleLastId = id;

		return id;

	}

	@RequestMapping("/mapUsr/article/getArticle")
	@ResponseBody
	public ResulData getArticle(int id) {

		Article article = getArticleId(id);

		if (article == null) {
			return new ResulData("F-1", id + "번 글이 존재하지 않습니다", "id", id);
		}

		return new ResulData("S-1", id + "번 글입니다", "article", article);

	}

	private Article getArticleId(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}
}
