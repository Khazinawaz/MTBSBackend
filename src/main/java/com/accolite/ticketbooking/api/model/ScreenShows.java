package com.accolite.ticketbooking.api.model;

import java.time.*;
public class ScreenShows {

private long showId;
private String screenId;
private long theatreId;
private LocalTime startTime;
private LocalTime duration;
private long movieId;
private LocalDate startDate;
private LocalDate endDate;

public long getShowId() {
	return showId;
}
public void setShowId(long showId) {
	this.showId = showId;
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
public LocalTime getStartTime() {
	return startTime;
}
public void setStartTime(LocalTime time) {
	this.startTime = time;
}
public LocalTime getDuration() {
	return duration;
}
public void setDuration(LocalTime duration) {
	this.duration = duration;
}
public long getMovieId() {
	return movieId;
}
public void setMovieId(long movieId) {
	this.movieId = movieId;
}
public LocalDate getStartDate() {
	return startDate;
}
public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}
public LocalDate getEndDate() {
	return endDate;
}
public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}


}
