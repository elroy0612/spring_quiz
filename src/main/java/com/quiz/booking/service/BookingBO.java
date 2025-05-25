package com.quiz.booking.service;

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
	
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	};
	
	public void addBooking(String name,int headcount, int day, String date,  String phoneNumber) {
		bookingMapper.insertBooking(name, headcount, day, date, phoneNumber);
	}
	
	public Booking getBookingByNameAndPhoneNumber(String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.selectBookingByNameAndPhoneNumber(name, phoneNumber);
		if (bookingList == null) {
			return null;
		}
		return bookingList.get(bookingList.size() - 1);
	}
}
