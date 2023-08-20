package com.hic.exam.demo.Conrtoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MapUsrHomeConrtoller {

	// 요청이 왔을 때 어떤 컨트롤러가 호출이 되어야 하는지 알려주는 지표
	@RequestMapping("/")


	public String showMainroot() {
		return "redirect:mapUsr/home/main";
	}
	
	@RequestMapping("/mapUsr/home/main")


	public String showMain() {
		return "mapUsr/home/main";
	}
}
