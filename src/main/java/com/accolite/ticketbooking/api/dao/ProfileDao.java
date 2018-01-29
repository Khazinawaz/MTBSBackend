package com.accolite.ticketbooking.api.dao;

import com.accolite.ticketbooking.api.model.Profile;

public interface ProfileDao {
	
	
	public Profile login(String email,String password);
	public Profile register(Profile profile);
	public Profile update(String fieldName, Object fieldValue,long userId);
	
}
