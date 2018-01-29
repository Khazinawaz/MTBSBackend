package com.accolite.ticketbooking.api.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import com.accolite.ticketbooking.api.dao.MovieDao;
import com.accolite.ticketbooking.api.daoimpl.MovieDaoImpl;
import com.accolite.ticketbooking.api.dto.MovieDto;
import com.accolite.ticketbooking.api.dto.ScreenDto;
import com.accolite.ticketbooking.api.dto.TheatreDto;
import com.accolite.ticketbooking.api.model.Movie;
import com.accolite.ticketbooking.api.model.Screen;
import com.accolite.ticketbooking.api.model.ScreenShows;
import com.accolite.ticketbooking.api.model.Theatre;
import com.accolite.ticketbooking.api.services.MovieService;

public class MovieServiceImpl implements MovieService {
MovieDao movieDao=new MovieDaoImpl();
	@Override
	public List<MovieDto> getMoviesByCity(String city) {
		
		List<MovieDto> moviesList=new ArrayList<MovieDto>();
		List<Movie> movies=movieDao.getMoviesByCity(city);
		for(Movie movie:movies)
		{
			MovieDto movieDto=new MovieDto();
			movieDto.setMovieId(movie.getMovieId());
			movieDto.setMovieName(movie.getMovieName());
			movieDto.setCast(movie.getCast());
			movieDto.setDuration(movie.getDuration());
			movieDto.setMovieRating(movie.getMovieRating());
			movieDto.setMovieDirector(movie.getMovieDirector());
			movieDto.setMovieGenre(movie.getMovieGenre());
			
			List<Theatre> theatres=movieDao.getTheatresByMovieAndCity(city, movie.getMovieId());
			List<TheatreDto> theatreDtos=new ArrayList<TheatreDto>();
			 	for(Theatre theatre:theatres)
			 	{
			 		
			 		TheatreDto theatreDto=new TheatreDto();
			 		
			 		theatreDto.setTheatreId(theatre.getTheatreId());
			 		theatreDto.setTheatreCity(city);
			 		theatreDto.setTheatreAddress(theatre.getTheatreAddress());
			 		theatreDto.setTheatreName(theatre.getTheatreName());
			 			
			 		List<Screen> screens=movieDao.getScreensByTheatreAndMovie(theatre.getTheatreId(),movie.getMovieId());
			 		List<ScreenDto> screenDtos=new ArrayList<ScreenDto>();
			 			
			 		for(Screen screen:screens)
			 		{
			 			ScreenDto screenDto=new ScreenDto();
			 			screenDto.setScreenId(screen.getScreenId());
			 			screenDto.setTheatreId(screen.getTheatreId());
			 			screenDto.setSeats(screen.getSeats());
			 			
			 			List<ScreenShows> screenShows=movieDao.getShowsByTheatreAndScreenAndMovie(movie.getMovieId(), screen.getScreenId(),theatre.getTheatreId());
			 			screenDto.setShows(screenShows);
			 			screenDtos.add(screenDto);
			 		}
			 		
			 		theatreDto.setScreenDto(screenDtos);
			 		theatreDtos.add(theatreDto);
			 	}
			 	movieDto.setTheatreDto(theatreDtos);
			 	moviesList.add(movieDto);
		}
		
		return moviesList; 
	}
	
	@Override
	public List<ScreenShows> getShowsByTheatreAndMovie(long movieId, long theatreId) {
		// TODO Auto-generated method stub
		return null;
	}


}
