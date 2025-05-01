package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.service.SellerBO;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {

	@GetMapping("/add-seller-view")
	public String addSeller() {
		return "lesson04/addSeller";
	}
	
	@Autowired
	private SellerBO sellerBO;
	
	@PostMapping("/add-seller")
	public String afterAddSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {
		
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	@GetMapping("/seller-info-view")
	public String sellerInfo(Model model,
			@RequestParam(value = "id", required = false) Integer id) {
		Seller seller;
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		return "lesson04/sellerInfo";
	}
}
