package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class lesson01Quiz03Controller {
	
	@RequestMapping("/lesson01/quiz03/1")
	public String quiz03_1() {
		// ResponseBody가 아닌 상태로 String을 return하면
		// viewResolver에 의해 리턴된 html 경로를 찾아 화면이 구성됨
		
		return "lesson01/quiz03";
	}
}
