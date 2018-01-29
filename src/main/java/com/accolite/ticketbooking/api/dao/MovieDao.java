package com.accolite.ticketbooking.api.dao;

import java.util.List;

import com.accolite.ticketbooking.api.model.Movie;
import com.accolite.ticketbooking.api.model.Screen;
import com.accolite.ticketbooking.api.model.ScreenShows;
import com.accolite.ticketbooking.api.model.Theatre;

public interface MovieDao {
	public List<Movie> getMoviesByCity(String city);
	public List<Theatre> getTheatresByMovieAndCity(String city,long movieId);
	public List<ScreenShows> getShowsByTheatreAndScreenAndMovie(long movieId,String screenId,long theatreId);
	public List<Screen> getScreensByTheatreAndMovie(long theatreId,long movieId);
	
}
