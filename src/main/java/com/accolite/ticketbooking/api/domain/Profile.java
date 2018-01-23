package com.accolite.ticketbooking.BookMyTicket.domain;

import java.util.Date;

public class Profile {
	
	private String email;
	transient private String password;
	private String firstName;
	private String lastName;
	private Long contactNo;
	
	
	private Date dob;
	private UserType type;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Profile [email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", contactNo=" + contactNo + ", dob=" + dob + ", type=" + type + "]";
	}
	
	
	
}
