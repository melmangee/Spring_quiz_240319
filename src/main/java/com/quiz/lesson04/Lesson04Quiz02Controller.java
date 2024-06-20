package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;
	
	// 공인 중개사 추가 페이지 입력화면
	@GetMapping("/add-realtor-view")
	// http://localhost:8080/lesson04/quiz02/add-realtor-view
	public String addRealtorView() {
		
		// 공인 중개사 추가 페이지 접속
		return "lesson04/addRealtor";
	}
	
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		
		// DB insert
		realtorBO.addRealtor(realtor);
		
		// DB id를 가지고 select
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());
		
		// model에 값 담기
		model.addAttribute("realtor", latestRealtor);
		
		// 결과 화면 이동
		return "lesson04/afterAddRealtor";
	}
}
