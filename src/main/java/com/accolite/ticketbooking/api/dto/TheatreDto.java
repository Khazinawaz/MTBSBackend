package com.accolite.ticketbooking.api.dto;

import java.util.List;

public class TheatreDto {

	private long theatreId;
	
	public long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(long theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreAddress() {
		return theatreAddress;
	}

	public void setTheatreAddress(String theatreAddress) {
		this.theatreAddress = theatreAddress;
	}

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
	}

	public List<ScreenDto> getScreenDto() {
		return ScreenDto;
	}

	public void setScreenDto(List<ScreenDto> screenDto) {
		ScreenDto = screenDto;
	}

	private String theatreName;
	
	private String theatreAddress;
	
	private String theatreCity;
	
	private List<ScreenDto> ScreenDto;
}
