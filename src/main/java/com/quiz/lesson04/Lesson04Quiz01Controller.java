package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	// seller 추가 화면
	@RequestMapping(path = "/add-seller-view", method = RequestMethod.GET)
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	//seller 화면 진행 => DB저장 => 결과 화면 (입력 성공 문구 출력)
	@PostMapping("/add-seller")
	// http://localhost:8080/lesson04/quiz01/add-seller
	public String addSeller(
			@RequestParam("nickname") String nickname, 
			@RequestParam(value = "profileImageUrl" , required = false) String profileImageUrl, 
			@RequestParam("temperature") double temperature) {
		
		//DB 저장
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 결과 화면 출력
		return "lesson04/afterAddSeller";
		
	}
	
	// 최근 추가된  seller의 정보
	// http:localhost:8080/lesson04/quiz01/seller-info-view
	
}