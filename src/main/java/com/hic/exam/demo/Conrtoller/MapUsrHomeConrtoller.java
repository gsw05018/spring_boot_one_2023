package com.hic.exam.demo.Conrtoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MapUsrHomeConrtoller {
	
	//요청이 왔을 때 어떤 컨트롤러가 호출이 되어야 하는지 알려주는 지표
	@RequestMapping("/mapUsr/home/main")
	//자바객체를 http 응답본문의 객체로 변환하여 클라이언트로 전송
	@ResponseBody
	public String showMain() {
		return "안녕";
	}
}
