package com.hic.exam.demo.Conrtoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

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
		makeTestData();
	}

	//write
	@RequestMapping("/mapUsr/article/doWrite")
	@ResponseBody
	public ResulData doWrite(String title, String body) {
		int id = writeArticle(title, body);
		Article article = getArticleId(id);
		return new ResulData("S-1", id + "번 글이 생성되었습니다", "aritcle", article);

	}

	//write 함수
	private int writeArticle(String title, String body) {

		int id = articleLastId + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();

		Article article = new Article(id, regDate, updateDate, title, body);
		articles.add(article);

		articleLastId = id;

		return id;

	}

	//detail
	@RequestMapping("/mapUsr/article/getArticle")
	@ResponseBody
	public ResulData getArticle(int id) {

		Article article = getArticleId(id);

		if (article == null) {
			return new ResulData("F-1", id + "번 글이 존재하지 않습니다", "id", id);
		}

		return new ResulData("S-1", id + "번 글입니다", "article", article);

	}
	
	//delete
	@RequestMapping("/mapUsr/article/doDelete")
	@ResponseBody
	public ResulData doDelete(int id) {
		boolean deleted = getDeleteId(id);
		
		if(deleted == false) {
			return new ResulData("F-1", id + "번이 존재하지 않습니다", "id", id);
		}
		
		
		return new ResulData("s-1", id + "번이 삭제되었습니다", "id", id);
		
	}
	
	@RequestMapping("/mapUsr/article/doModify")
	@ResponseBody
	public ResulData doModify(int id,String title, String body){
		
		boolean article = modifyArticle(id, title, body);
		
		if(article == false) {
			return new ResulData("F-1", id + "번 글이 존재하지 않습니다", "id", id);
		}
		
		return new ResulData("S-1", id + "번 글이 수정되었습니다", "article", getArticleId(id));
		
	}
	
	//modifyArticle 함수
	private boolean modifyArticle(int id, String title, String body) {
		
		Article article = getArticleId(id);
		
		if(article == null) {
			return false;
			
		}
		
		article.setTitle(title);
		article.setBody(body);
		article.setUpdateDate(Util.getNowDateStr());
		return true;
	}

	//게시물 삭제할 번호 찾는 함수
	private boolean getDeleteId(int id) {
		for(Article article : articles) {
			if(article.getId() == id) {
				articles.remove(article);
				return true;
			}
		}
		return false;
	}

	//게시물 번호 찾기
	private Article getArticleId(int id) {
		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}
		return null;
	}
	
	private void makeTestData(){
		for(int i = 0; i <= 3; i++) {
			writeArticle("제목1", "내용1");
		}
	}
}
