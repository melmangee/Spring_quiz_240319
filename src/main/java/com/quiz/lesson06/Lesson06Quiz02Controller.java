package com.quiz.lesson06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson06/quiz02")
@Controller
public class Lesson06Quiz02Controller {

	// 즐겨찾기 추가하기 화면
	@GetMapping("/add-bookmark-view")
	// http://localhost:8080/lesson06/quiz02/add-bookmark-view
	public String addBookmarkView() {
		
		return "lesson06/quiz02AddBookmark";
	}
}
