package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	// 예약 목록 화면
	// http://localhost:8080/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		
		// DB selelct
		List<Booking> bookingList = bookingBO.getBookingList();
		
		// model 저장
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	// AJAX가 보내는 요청 - 예약 id로 삭제
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking (
			@RequestParam("id") int id ) {
		
		// db-delete
		 int rowCount = bookingBO.deleteBookingById(id);
		
		// json 응답값
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
	
	
	
	
	// 예약 하기 화면
	// http://localhost:8080/booking/make-booking-view
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	//AJAX 요청 - add 예약
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
		@RequestParam("name") String name,
		@RequestParam("date") LocalDate date, // String도 된다.
		@RequestParam("day") int day,
		@RequestParam("headcount") int headcount,
		@RequestParam("phoneNumber") String phoneNumber) {
			
		// db insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
	
	
	
	// 예약목록조회 페이지
	// http://localhost:8080/booking/check-booking-view
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	// AJAX 의 요청 - select 예약
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
		@RequestParam("name") String name,
		@RequestParam("phoneNumber") String phoneNumber) {
		
	// DB select 조회
	 Booking booking = bookingBO.getLatestBookingByNamePhoneNumber(name, phoneNumber);	
		
	// json 응답
	Map<String, Object> result = new HashMap<>();
	if (booking != null) {
		// {"code":200, "result":booking 객체}
		// {"code":200, "result":"id":3, "name":"신보람"....}
		result.put("code", 200);
		result.put("result", booking);
	} else {
		// {"code":500, "error_message":"예약 내역이 없습니다."}
		result.put("code", 500);
		result.put("error_message", "예약 내역이 없습니다.");
	}
		return result;
	
	}
	
}
