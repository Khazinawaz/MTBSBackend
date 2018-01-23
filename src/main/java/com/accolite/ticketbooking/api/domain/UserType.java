package com.accolite.ticketbooking.BookMyTicket.domain;

public enum UserType {

	
	NORMAL_USER ("normal_user"),
    SUPER_ADMIN ("super_admin"),
    THEATER_ADMIN ("theater_admin");

    private final String name;       

    private UserType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false 
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}

