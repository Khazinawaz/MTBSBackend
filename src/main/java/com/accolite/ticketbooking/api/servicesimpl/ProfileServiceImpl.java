package com.accolite.ticketbooking.api.servicesimpl;




import com.accolite.ticketbooking.api.dao.ProfileDao;

import com.accolite.ticketbooking.api.daoimpl.ProfileDaoImpl;
import com.accolite.ticketbooking.api.model.Profile;
import com.accolite.ticketbooking.api.services.ProfileService;
import com.accolite.ticketbooking.validators.Validator;



public class ProfileServiceImpl implements ProfileService {

	ProfileDao profileDao=new ProfileDaoImpl();
	
	@Override
	public Profile login(String email,String password) {

	if(!Validator.validateEmail(email) && !Validator.validatePassword(password))
		return null;
	Profile profile1=profileDao.login(email,password);
	if(profile1==null)
		return null;
	
		return profile1;
	}

	@Override
	public Profile register(Profile profile) {

		if(!Validator.validateEmail(profile.getEmail()) && !Validator.validateDOB(profile.getDob())&& !Validator.validatePassword(profile.getPassword()))
			return null;
		
		return profileDao.register(profile);
	}

	@Override
	public Profile update(Profile profile) {

		if(profile.getContactNo()!=null && Validator.validateContactNumber(profile.getContactNo()))
		{	profile=profileDao.update("contact_number", profile.getContactNo(),profile.getProfileId());}
		
		if(profile.getEmail()!=null && Validator.validateEmail(profile.getEmail()))
			{profile=profileDao.update("email", profile.getEmail(),profile.getProfileId());}
		
		if(profile.getPassword()!=null && Validator.validatePassword(profile.getPassword()))
			{profile=profileDao.update("password", profile.getPassword(),profile.getProfileId());}
		
		if(profile.getDob()!=null && Validator.validateDOB(profile.getDob()))
		{	profile=profileDao.update("dob",profile.getDob(),profile.getProfileId());}
			
		
		return profile;
	}

	

	
	

	
	
}
