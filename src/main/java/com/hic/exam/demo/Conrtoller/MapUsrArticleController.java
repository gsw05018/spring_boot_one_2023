package com.hic.exam.demo.Conrtoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hic.exam.demo.Dto.Article;
import com.hic.exam.demo.Dto.Board;
import com.hic.exam.demo.Dto.ResultData;
import com.hic.exam.demo.service.ArticleService;
import com.hic.exam.demo.util.Util;

@Controller
public class MapUsrArticleController {
	@Autowired
	private ArticleService articleService;

	private String msgAndBack(HttpServletRequest req, String msg) {
		
		req.setAttribute("msg", msg);
		req.setAttribute("historyBack", true);
		
		return "mapUsr/common/redirect";
		
	}
	private String msgAndReplace(HttpServletRequest req, String msg, String replaceUrl) {
		
		req.setAttribute(msg, msg);
		req.setAttribute(replaceUrl, replaceUrl);
		return "mapUsr/common/redirect";
		
	}
	
	
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
	@RequestMapping("/mapUsr/article/list")
	public String showList(HttpServletRequest req,int boardId){
		
		Board board = articleService.getArticleByBoardId(boardId);
		
		if(board == null) {
			
			return msgAndBack(req, boardId + "번 게시판이 존재하지 않습니다");
		}
		
		req.setAttribute("board", board);
		
		int totalItemsCount = articleService.getArticlesTotalCount(boardId);
		
		req.setAttribute("totalItemsCount", totalItemsCount);
		
		return "/mapUsr/article/list";
	}


	// delete
	@RequestMapping("/mapUsr/article/doDelete")
	public String doDelete(HttpServletRequest req, Integer id) {
		if (Util.isEmpty(id)) {
			return msgAndBack(req, "id를 입력해주세요.");
		}
		
		ResultData rd = articleService.deleteArticleById(id);
		
		if ( rd.isFail() ) {
			return msgAndBack(req, rd.getMsg());
		}
		
		String redirectUrl = "../article/list?boardId=" + rd.getBody().get("boardId");
		
		return msgAndReplace(req, rd.getMsg(), redirectUrl);	
		
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
