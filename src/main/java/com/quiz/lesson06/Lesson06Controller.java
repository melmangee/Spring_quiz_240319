package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {

	@Autowired
	private BookmarkBO bookmarkBO;

	// 즐겨찾기 목록 추가 화면
	@GetMapping("/add-bookmark-view")
	// http://localhost:8080/lesson06/add-bookmark-view
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}

	// AJAX가 하는 요청 -> AJAX가 하는 응답값은 반드시 String이다.
	// 즐겨찾기 추가 로직
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name, 
			@RequestParam("url") String url) {

		//db insert
		bookmarkBO.addBookMark(name, url);
		
		// 성공 JSON
		// {"code":200, "result":"성공"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result; // JSON String

	}

	// 결과 페이지(즐겨찾기 목록)

	@GetMapping("/bookmark-list-view")
	// http://localhost:8080/lesson06/bookmark-list-view
	public String bookmarkListView(Model model) {

		// db select => List<Bookmark>
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();

		// model
		model.addAttribute("bookmarkList", bookmarkList);

		return "lesson06/bookmarkList";
	}
}
