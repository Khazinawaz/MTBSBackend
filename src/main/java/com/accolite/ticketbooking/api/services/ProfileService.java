package com.accolite.ticketbooking.api.services;

import java.util.Map;

import com.accolite.ticketbooking.api.model.Profile;


public interface ProfileService {
	public Profile login(String email,String password);
	public Profile register(Profile profile);
	public Profile update(Profile profile);
	
}
