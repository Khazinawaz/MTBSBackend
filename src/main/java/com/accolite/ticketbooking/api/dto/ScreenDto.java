package com.accolite.ticketbooking.api.dto;

import java.util.List;

import com.accolite.ticketbooking.api.model.ScreenShows;

public class ScreenDto {

	private String screenId;

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(long theatreId) {
		this.theatreId = theatreId;
	}

	public String[] getSeats() {
		return seats;
	}

	public void setSeats(String[] seats) {
		this.seats = seats;
	}

	public List<ScreenShows> getShows() {
		return shows;
	}

	public void setShows(List<ScreenShows> shows) {
		this.shows = shows;
	}

	private long theatreId;

	private String seats[];
	
	private List<ScreenShows> shows;
}
