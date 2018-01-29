package com.accolite.ticketbooking.api.model;

import java.util.Map;

public class Screen {
	

private String screenId;

private long theatreId;

private long noOfRows;
public long getNoOfRows() {
	return noOfRows;
}
public void setNoOfRows(long noOfRows) {
	this.noOfRows = noOfRows;
}
public long getNoOfSeats() {
	return noOfSeats;
}
public void setNoOfSeats(long noOfSeats) {
	this.noOfSeats = noOfSeats;
}
private long noOfSeats;

private String seats[];




public String[] getSeats() {
	return seats;
}
public void setSeats(String[] seats) {
	this.seats = seats;
}
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


}
