package com.quiz.booking.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBooking() {
		return bookingMapper.selectBooking();
	}
	
	public void deleteBookingById(int id) {
		bookingMapper.deleteBookingById(id);
	};
	
	public void addBooking(String name,int headcount, int day, String date,  String phoneNumber) {
		bookingMapper.insertBooking(name, headcount, day, date, phoneNumber);
	}
}
