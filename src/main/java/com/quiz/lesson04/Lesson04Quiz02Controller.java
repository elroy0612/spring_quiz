package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.service.RealtorBO;

@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;
	
	@GetMapping("/lesson04/quiz02/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	@PostMapping("/lesson04/quiz02/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		
		realtorBO.addRealtor(realtor);
		
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());
		model.addAttribute("realtor", latestRealtor);
		
		return "lesson04/afterAddRealtor";
	}
	
}
