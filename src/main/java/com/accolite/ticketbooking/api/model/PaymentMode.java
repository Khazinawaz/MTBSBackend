package com.accolite.ticketbooking.api.model;

public enum PaymentMode {

	
	DEBIT_CARD ("debit_card"),
    CREDIT_CARD ("credit_card"),
    NET_BANKING ("net_banking");

    private final String name;       

    private PaymentMode(String s) {
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

