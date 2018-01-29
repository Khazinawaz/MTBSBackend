package com.accolite.ticketbooking.api.dao;

import java.time.LocalDate;
import java.util.List;

public interface BookingDao {

	public List<LocalDate> ifBookingMade(long showId);
}
