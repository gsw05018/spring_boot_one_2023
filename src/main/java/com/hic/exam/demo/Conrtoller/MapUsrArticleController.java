package com.hic.exam.demo.Conrtoller;

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
		int id = articleService.writeArticle(title, body);
		Article article = articleService.getArticleId(id);
		return new ResultData("S-1", id + "번 글이 생성되었습니다", "aritcle", article);

	}

	// write 함수
	
	// detail
	@RequestMapping("/mapUsr/article/getArticle")
	@ResponseBody
	public ResultData getArticle(int id) {
		if (Util.isEmpty(id)) {
			return new ResultData("F-1", "번호를 입력해주세요.");
		}
		Article article = articleService.getArticleId(id);

		if (article == null) {
			return new ResultData("F-1", id + "번 글이 존재하지 않습니다", "id", id);
		}

		return new ResultData("S-1", id + "번 글입니다", "article", article);

	}

	// delete
	@RequestMapping("/mapUsr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(int id) {
		if (Util.isEmpty(id)) {
			return new ResultData("F-1", "번호를 입력해주세요.");
		}
		boolean deleted = articleService.getDeleteId(id);

		if (deleted == false) {
			return new ResultData("F-1", id + "번이 존재하지 않습니다", "id", id);
		}

		return new ResultData("s-1", id + "번이 삭제되었습니다", "id", id);

	}

	// modify
	@RequestMapping("/mapUsr/article/doModify")
	@ResponseBody
	public ResultData doModify(int id, String title, String body) {
		if(Util.isEmpty(id)) {
			return new ResultData("F-1", "번호를 입력해주세요.");
		}if(Util.isEmpty(title)) {
			return new ResultData("F-2", "제목를 입력해주세요.");
		}if(Util.isEmpty(body)) {
			return new ResultData("F-3", "내용를 입력해주세요.");
		}
		boolean article = articleService.modifyArticle(id, title, body);

		if (article == false) {
			return new ResultData("F-1", id + "번 글이 존재하지 않습니다", "id", id);
		}

		return new ResultData("S-1", id + "번 글이 수정되었습니다", "article", articleService.getArticleId(id));

	}

	
}
