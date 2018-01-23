package com.accolite.ticketbooking.BookMyTicket.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value="/")
public class HomeController {
	
	@RequestMapping(value="/")
	public String printHello() {
		
		
		return null;
	}
}
