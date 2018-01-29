package com.accolite.ticketbooking.validators;

import java.time.LocalDate;

public class Validator {
	private Validator() {};
	public  static boolean validateEmail(String email)
	{
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
		
	}
	
	public static boolean validatePassword(String password)
	{
		
		return password!=null;
		
	}
	
	public static boolean validateContactNumber(long contactNumber)
	{	
		 
		return (Long.toString(contactNumber).matches("\\d{10}")) ;
	}
	
	public static boolean validateDOB(LocalDate dob)
	{
		
		return dob.isBefore(LocalDate.now().minusYears(18));
	}
	
	
}
