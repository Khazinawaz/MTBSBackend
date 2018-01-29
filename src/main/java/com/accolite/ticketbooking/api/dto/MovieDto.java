package com.accolite.ticketbooking.api.dto;

import java.time.LocalTime;
import java.util.List;

public class MovieDto {
	
	private long movieId;
	private String movieName;
	private String cast;
	private float movieRating;
	private String movieGenre;
	private String movieDirector;
	private LocalTime duration;
	private String moviePicUrl;
	private List<TheatreDto> theatreDto;
	
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public float getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(float movieRating) {
		this.movieRating = movieRating;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public LocalTime getDuration() {
		return duration;
	}
	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	public String getMoviePicUrl() {
		return moviePicUrl;
	}
	public void setMoviePicUrl(String moviePicUrl) {
		this.moviePicUrl = moviePicUrl;
	}
	
	
	
	public List<TheatreDto> getTheatreDto() {
		return theatreDto;
	}
	public void setTheatreDto(List<TheatreDto> theatreDto) {
		this.theatreDto = theatreDto;
	}
	
}
