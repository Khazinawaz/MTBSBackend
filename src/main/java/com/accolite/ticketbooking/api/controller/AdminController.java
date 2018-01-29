package com.accolite.ticketbooking.api.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.ticketbooking.api.model.Movie;
import com.accolite.ticketbooking.api.model.Profile;
import com.accolite.ticketbooking.api.model.Screen;
import com.accolite.ticketbooking.api.model.ScreenShows;
import com.accolite.ticketbooking.api.model.Theatre;
import com.accolite.ticketbooking.api.services.AdminService;
import com.accolite.ticketbooking.api.servicesimpl.AdminServiceImpl;


@RestController("/admin")
public class AdminController {
	
	AdminService adminService=new AdminServiceImpl();
	
	@RequestMapping(value = "/getTheatres",method = RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Theatre>> getTheatres(@RequestParam String city){
		List<Theatre> theatres=adminService.getTheatres(city);
		
		return new ResponseEntity<List<Theatre>>(theatres,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/getShows",method = RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ScreenShows>> getShows(@RequestParam long theatreId,long screenId){
		List<ScreenShows> shows=adminService.getShows(theatreId,screenId);
		
		return new ResponseEntity<List<ScreenShows>>(shows,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/addShow",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScreenShows> addShow(@RequestBody ScreenShows screenShow){
		 screenShow=adminService.addShow(screenShow);
		
		return new ResponseEntity<ScreenShows>(screenShow,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/removeShow",method = RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> removeShow(@RequestBody long showId){
		 String message=adminService.removeShow(showId);
		
		return new ResponseEntity<String>(message,HttpStatus.OK);
	

	}
	
	

	@RequestMapping(value = "/updateShow",method = RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ScreenShows> updateShow(@RequestBody long theatreId,@RequestBody long screenId){
	ScreenShows screenShow=adminService.updateShow(theatreId,screenId);
		
		return new ResponseEntity<ScreenShows>(screenShow,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/addAdmin",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Profile> addAdmin(@RequestBody Profile profile){
	profile=adminService.addAdmin(profile);
		
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/addMovie",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
	movie=adminService.addMovie(movie);
		
		return new ResponseEntity<Movie>(movie,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/addTheatre",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre ){
	theatre=adminService.addTheatre(theatre);
		
		return new ResponseEntity<Theatre>(theatre,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/addScreen",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Screen> addScreen(@RequestBody Screen screen ){
	screen=adminService.addScreen(screen);
		
		return new ResponseEntity<Screen>(screen,HttpStatus.OK);
		
	}
	

}
