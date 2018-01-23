package com.accolite.ticketbooking.BookMyTicket.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.ticketbooking.BookMyTicket.domain.Profile;
import com.accolite.ticketbooking.BookMyTicket.domain.Token;


@RestController
public class AuthController {
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public Profile register(@RequestBody Profile profile) {
		Token token = new Token();
		System.out.println(profile);
		token.setToken("token");
		return profile;
	}

}
