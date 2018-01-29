package com.accolite.ticketbooking.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.ticketbooking.api.model.Theatre;

import com.accolite.ticketbooking.api.services.BookingService;

import com.accolite.ticketbooking.api.servicesimpl.BookingServiceImpl;

@RestController
public class BookingController {

	
BookingService bookingService=new BookingServiceImpl();
	
	@RequestMapping(value = "/getAvailableSeats",method = RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Screen> getAvailableSeats(@RequestParam String city){
		List<Theatre> theatres=adminService.getTheatres(city);
		
		return new ResponseEntity<List<Theatre>>(theatres,HttpStatus.OK);
		
	}
}
