package com.accolite.ticketbooking.api.controller;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.ticketbooking.api.model.Profile;
import com.accolite.ticketbooking.api.services.ProfileService;
import com.accolite.ticketbooking.api.servicesimpl.ProfileServiceImpl;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;


@RestController
public class ProfileController {

	
	
		
	
	ProfileService profileService=new ProfileServiceImpl();
	
	@RequestMapping(value = "/login",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Profile> login(@RequestBody Profile request) {
		
		 request=profileService.login(request.getEmail(), request.getPassword());
		return new ResponseEntity<Profile>(request,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Profile> register(@RequestBody Profile profile)
	{
	
		
		profile=profileService.register(profile);
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Profile> update(@RequestBody Profile profile)
	{
		
		profile=profileService.update(profile);
		
		
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}

}
