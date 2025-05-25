package com.quiz.booking;

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

import com.quiz.booking.domain.Booking;
import com.quiz.booking.service.BookingBO;

@RequestMapping("/booking")
@Controller
public class BookingController {

	@Autowired
	private BookingBO bookingBO;
	
	@GetMapping("/booking-list-view")
	public String BookingListView(Model model) {
		
		List<Booking> bookingList = bookingBO.getBooking();
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		
		int rowCount = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 대상이 없습니다.");
		}
		
		return result;
	}
	
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		
		return "booking/makeBooking";
	}
	
	@PostMapping("/make-booking")
	@ResponseBody
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name,
			@RequestParam("headcount") int headcount,
			@RequestParam("day") int day,
			@RequestParam("date") String date,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		bookingBO.addBooking(name, headcount, day, date, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
		
	}
	
	@GetMapping("/check-booking-view")
	public String chechBookingView() {
		
		return "booking/checkBooking";
	}
	
	@PostMapping("/check-booking")
	@ResponseBody
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingBO.getBookingByNameAndPhoneNumber(name, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		if (booking == null) {
			result.put("code", 400);
			result.put("error_message", "예약 내역이 없습니다.");
		} else {
			result.put("code", 200);
			result.put("result", booking);
		}
		
		return result;
	}
}
