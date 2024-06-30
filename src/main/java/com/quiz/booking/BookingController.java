package com.quiz.booking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	// 예약 목록 페이지
	// http://localhost:8080/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		
		// DB selelct
		List<Booking> bookingList = bookingBO.getBooking();
		
		// model 저장
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	// AJAX가 보내는 요청 del-btn
	@ResponseBody
	@DeleteMapping("delete-booking")
	public Map<String, Object> deleteBooking (
			@RequestParam("id") int id ) {
		
		// db-delete
		 int rowCount = bookingBO.deleteBookingById(id);
		
		// json 응답
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 항목이 없습니다.");
		}
		return result;
	}
	
	
	
	
	// 예약 하기 페이지
	// http://localhost:8080/booking/make-booking-view
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	
	
	
	// 예약목록조회 페이지
	// http://localhost:8080/booking/check-booking-view
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
}
