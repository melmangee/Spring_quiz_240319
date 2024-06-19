package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	//seller 화면 진행 => DB저장 => 결과 화면 (입력 성공 문구 출력)
	
	// 판매자 (seller) 추가 화면
	@GetMapping("/add-seller-view")
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	public String addSellerView() {
		return "lesson04/addSeller";
	}

	// 판매자 DB에 저장 => 성공 화면
	@PostMapping("/add-seller")
	// http://localhost:8080/lesson04/quiz01/add-seller
	public String addSeller(
			@RequestParam("nickname") String nickname, 
			@RequestParam(value = "profileImageUrl" , required = false) String profileImageUrl, 
			@RequestParam(value = "temperature", defaultValue = "36.5") double temperature) {
		
		//DB insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// 결과 화면 출력(성공화면)
		return "lesson04/afterAddSeller";
		
	}
	
	// 방금 가입한 판매자 1명 화면
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	// http://localhost:8080/lesson04/quiz01/seller-info-view?id=3
	@GetMapping("/seller-info-view")
	public String sellerInfoView(@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		
		Seller seller = null;
		
		// 데이터 조회
		
		if(id == null) {
			 seller = sellerBO.getLatestSeller();			
		} else {
			 seller = sellerBO.getSellerById(id);
		}
		
		// Model에 데이터를 담아둔다.
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");
		
		// 화면
		return "lesson04/sellerInfo";
	}
	
}