package com.hic.exam.demo.Conrtoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hic.exam.demo.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class MapUsrArticleController {
	int articleLastId = 0;
	

	@RequestMapping("/mapUsr/article/doWrite")
	@ResponseBody
	public ResulData doWrite(String title, String body) {
		int id = articleLastId +1; 
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();
		
		Article article = new Article(id, regDate, updateDate, title, body);
		
		articleLastId = id;
		
		return new ResulData("S-1", id + "번 글이 생성되었습니다", article);

	}
	
//	@RequestMapping("/mapUsr/article/showList")
//	@ResponseBody
//	public List<Article> showList(){
//		
//		Article articles; ;
//		
//		
//		
//	} 
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ResulData{
	private String ResulData;
	private String mas;
	private Article article;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Article {

	private int id;
	private String regDate;
	private String updateDate;
	private String title;
	private String body;

	

}
