package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.service.StoreBO;

@RestController // @Controller + @ResponseBody
public class Lesson02Quiz01RestController {

	@Autowired
	private StoreBO storeBO; // DI
	
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01() {
		return storeBO.GetStoreList(); // 응답(Response) -> JSON
	}
}
