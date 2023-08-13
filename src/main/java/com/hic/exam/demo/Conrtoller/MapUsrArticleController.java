package com.hic.exam.demo.Conrtoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hic.exam.demo.Dto.Article;
import com.hic.exam.demo.Dto.ResultData;
import com.hic.exam.demo.service.ArticleService;
import com.hic.exam.demo.util.Util;

@Controller
public class MapUsrArticleController {
	@Autowired
	private ArticleService articleService;

	// write
	@RequestMapping("/mapUsr/article/doWrite")
	@ResponseBody
	public ResultData doWrite(String title, String body) {
		if (Util.isEmpty(title)) {
			return new ResultData("F-1", "제목을 입력해주세요.");
		}
		if (Util.isEmpty(body)) {
			return new ResultData("F-2", "내용을 입력해주세요");
		}

		return articleService.writeArticle(title, body);

	}

	// detail
	@RequestMapping("/mapUsr/article/getArticle")
	@ResponseBody
	public ResultData getArticle(Integer id) {
		if (Util.isEmpty(id)) {
			return new ResultData("F-1", "번호를 입력해주세요.");
		}
		Article article = articleService.getArticleId(id);

		if (article == null) {
			return new ResultData("F-1", id + "번 글이 존재하지 않습니다", "id", id);
		}

		return new ResultData("S-1", id + "번 글입니다", "article", article);

	}
	
	//list
	@RequestMapping("/mapUsr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles(){
		
		return articleService.getArticles();
	}

	// delete
	@RequestMapping("/mapUsr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(Integer id) {
		if (Util.isEmpty(id)) {
			return new ResultData("F-1", "번호를 입력해주세요.");
		}
		Article article = articleService.getArticleId(id);

		if (article == null) {
			return new ResultData("s-1", id + "번이 존재하지 않습니다.", "id", id);

		}

		return articleService.deleteArticleById(id);
	}

	// modify
	@RequestMapping("/mapUsr/article/doModify")
	@ResponseBody
	public ResultData doModify(Integer id, String title, String body) {
		if (Util.isEmpty(id)) {
			return new ResultData("F-1", "번호를 입력해주세요.");
		}
		if (Util.isEmpty(title)) {
			return new ResultData("F-2", "제목를 입력해주세요.");
		}
		if (Util.isEmpty(body)) {
			return new ResultData("F-3", "내용를 입력해주세요.");
		}
		Article article = articleService.getArticleId(id);

		if (article == null) {
			return new ResultData("S-1", id + "번 글이 존재하지 않습니다", "id", id);
		}
		return articleService.modifyArticle(id, title, body);
	}

}
