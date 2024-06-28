package com.quiz.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	// 부킹 리스트 페이지
	// http://localhost:8080/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		
	// DB select
	List<Booking> bookingList = bookingBO.getBooking();
	
	// model 저장
	model.addAttribute("bookingList", bookingList);
	
	
	return "booking/bookingList";
	}
	
	// 예약하기 페이지
	// http://localhost:8080/booking/make-booking-view
	@GetMapping("make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
}
