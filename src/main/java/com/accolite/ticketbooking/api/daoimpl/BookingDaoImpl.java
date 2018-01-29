package com.accolite.ticketbooking.api.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.accolite.ticketbooking.api.dao.BookingDao;
import com.accolite.ticketbooking.api.databaseconnection.DataAccessObject;
import com.accolite.ticketbooking.api.model.Profile;


public class BookingDaoImpl implements BookingDao {
	private Connection connection;
	
	 public BookingDaoImpl() {
	
		connection = DataAccessObject.getInstance().Connect();
	}
	

	@Override
	public List<LocalDate> ifBookingMade(long showId) {
		// TODO Auto-generated method stub
		PreparedStatement preparedstmnt=null;
		ResultSet rs=null;
		List<LocalDate> bookedShowDates=null;
		try {
			preparedstmnt = connection.prepareStatement("select show_date from booked_seats_history where show_id_fk=?");
			preparedstmnt.setLong(1,showId);
			
			 rs=preparedstmnt.executeQuery();
			 bookedShowDates=new ArrayList<LocalDate>();
			while(rs.next())
				{
				bookedShowDates.add(rs.getDate(3).toLocalDate());
				
				}
			preparedstmnt.close();
			rs.close();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
