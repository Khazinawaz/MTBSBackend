package com.accolite.ticketbooking.BookMyTicket.services;

import com.accolite.ticketbooking.BookMyTicket.dao.AuthDao;
import com.accolite.ticketbooking.BookMyTicket.domain.Token;

public class AuthService implements IAuthService {

	private AuthDao authdao = new AuthDao();
	
	@Override
	public Token login(String email, String password) {
		
		return null;
	}

	@Override
	public Token register(String fullName, String password, String reTypePassword) {
		
		return null;
	}

}
