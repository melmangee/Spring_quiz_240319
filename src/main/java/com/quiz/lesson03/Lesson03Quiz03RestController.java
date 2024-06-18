package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RequestMapping("/lesson03/quiz03")
@RestController
public class Lesson03Quiz03RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	//http://localhost:8080/lesson03/quiz03/1?id=8&price=70000
	
	@RequestMapping("/1")
	public String quiz03_1(
			@RequestParam("id")int id,
			@RequestParam("price")int price) {
		int rowCount = realEstateBO.updateRealEstateById(id, price);
			return "수정 성공 : " + rowCount;
	}
}