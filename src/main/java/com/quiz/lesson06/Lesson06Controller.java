package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	// 즐겨찾기 목록 추가 화면
	@GetMapping("/add-bookmark-view")
	// http://localhost:8080/lesson06/add-bookmark-view
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
}
