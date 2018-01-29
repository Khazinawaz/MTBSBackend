package com.accolite.ticketbooking.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.ticketbooking.api.dto.MovieDto;
import com.accolite.ticketbooking.api.model.Movie;
import com.accolite.ticketbooking.api.model.ScreenShows;
import com.accolite.ticketbooking.api.model.Theatre;
import com.accolite.ticketbooking.api.services.MovieService;
import com.accolite.ticketbooking.api.servicesimpl.MovieServiceImpl;

@RestController("/movies")
public class MovieController {
	MovieService movieService=new MovieServiceImpl();
	@RequestMapping("/getMovieByCity")
	public List<MovieDto> getMoviesByCity(@RequestParam String city){
		
		List<MovieDto> movieList=movieService.getMoviesByCity(city);
		return null;
	}
	
	
	
	
	
	
}
