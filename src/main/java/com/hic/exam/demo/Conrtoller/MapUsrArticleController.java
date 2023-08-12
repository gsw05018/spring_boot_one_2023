package com.hic.exam.demo.Conrtoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hic.exam.demo.util.Util;

@Controller
public class MapUsrArticleController {
	int articleLastId = 0;
	

	@RequestMapping("/mapUsr/article/doWrite")
	@ResponseBody
	public String doWrite(String title, String body) {
		int id = articleLastId +1; 
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();
		
		
		articleLastId = id;
		
		return id + "번 글이 작성되었습니다";

	}
}

class Article{
	
	private int id;
	private String regDate;
	private String updateDate;
	private String title;
	private String body;
	
	Article(int id, String regDate, String updateDate, String title, String body){
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.title = title;
		this.body = body;
		
	}

	
	@Override
	public String toString() {
		return "Article [id=" + id + ", regDate=" + regDate + ", updateDate=" + updateDate + ", title=" + title
				+ ", body=" + body + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	
}
