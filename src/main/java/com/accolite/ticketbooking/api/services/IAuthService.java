package com.accolite.ticketbooking.BookMyTicket.services;

import com.accolite.ticketbooking.BookMyTicket.domain.Token;

public interface IAuthService {
	public Token login(String fullName,String password);
	public Token register(String fullName,String password,String reTypePassword);
	
}
