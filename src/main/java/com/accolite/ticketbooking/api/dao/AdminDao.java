package com.accolite.ticketbooking.api.dao;

import java.util.List;

import com.accolite.ticketbooking.api.model.Movie;
import com.accolite.ticketbooking.api.model.Profile;
import com.accolite.ticketbooking.api.model.Screen;
import com.accolite.ticketbooking.api.model.ScreenShows;
import com.accolite.ticketbooking.api.model.Theatre;

public interface AdminDao {
	
	public ScreenShows addShow(ScreenShows screenShows);
	public String removeShow(long showId);
	public List<ScreenShows> getShows(long theatreId,long screenId );
	public ScreenShows updateShow(long theatreId,long screenId );
	public Profile addAdmin(Profile profile);
	public Movie addMovie(Movie movie);
	public List<Theatre> getTheatres(String city);
	public Theatre addTheatre(Theatre theatre);
	public Screen addScreen(long theatreId);
}
