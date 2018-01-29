package com.accolite.ticketbooking.api.services;

import java.util.List;

import com.accolite.ticketbooking.api.dto.MovieDto;
import com.accolite.ticketbooking.api.dto.TheatreDto;
import com.accolite.ticketbooking.api.model.Movie;
import com.accolite.ticketbooking.api.model.ScreenShows;
import com.accolite.ticketbooking.api.model.Theatre;

public interface MovieService {

	public List<MovieDto> getMoviesByCity(String city);
	//public List<TheatreDto> getTheatresByMovieAndCity(String city,long movieId);
	public List<ScreenShows> getShowsByTheatreAndMovie(long movieId,long theatreId);
}
