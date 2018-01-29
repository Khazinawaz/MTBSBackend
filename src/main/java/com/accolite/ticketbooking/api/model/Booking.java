package com.accolite.ticketbooking.api.model;
import java.time.*;
public class Booking {

	private long bookingId;
	
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	private LocalDate date;

}
