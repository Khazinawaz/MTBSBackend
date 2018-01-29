package com.accolite.ticketbooking.api.servicesimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.accolite.ticketbooking.api.dao.AdminDao;
import com.accolite.ticketbooking.api.daoimpl.AdminDaoImpl;
import com.accolite.ticketbooking.api.daoimpl.BookingDaoImpl;
import com.accolite.ticketbooking.api.model.Movie;
import com.accolite.ticketbooking.api.model.Profile;
import com.accolite.ticketbooking.api.model.Screen;
import com.accolite.ticketbooking.api.model.ScreenShows;
import com.accolite.ticketbooking.api.model.Theatre;
import com.accolite.ticketbooking.api.services.AdminService;

public class AdminServiceImpl implements AdminService{

	AdminDao adminDao=new AdminDaoImpl();
	@Override
	public ScreenShows addShow(ScreenShows screenShows) {

		List<ScreenShows> shows=adminDao.getShows(screenShows.getTheatreId(), screenShows.getScreenId());
		for(ScreenShows s:shows)
		{
			if(s.getEndDate().isAfter(screenShows.getEndDate()))
					{
					LocalTime lt=s.getStartTime();
					lt=lt.plusHours(s.getDuration().getHour()).plusMinutes(s.getDuration().getMinute());
					if(lt.isAfter(screenShows.getStartTime()))
						return null;
					}
		}
		return adminDao.addShow(screenShows);
	}

	@Override
	public String removeShow(long showId) {

		
		List<LocalDate> bookings=new BookingDaoImpl().ifBookingMade(showId);
		for(LocalDate date:bookings)
		{
			if(date.isAfter(LocalDate.now()))
				return "cannot remove show,bookings  have already been made"; 
		}
			
		return adminDao.removeShow(showId);
		
	}

	@Override
	public List<ScreenShows> getShows(long theatreId, long screenId) {

		
		return adminDao.getShows(theatreId, screenId);
	}

	@Override
	public ScreenShows updateShow(long theatreId, long screenId) {

		return adminDao.updateShow(theatreId, screenId);
	}

	@Override
	public Profile addAdmin(Profile profile) {

	 return new ProfileServiceImpl().register(profile);
	}

	@Override
	public Movie addMovie(Movie movie) {

		
		return adminDao.addMovie(movie);
	}

	@Override
	public List<Theatre> getTheatres(String city) {

		return adminDao.getTheatres(city);
	}

	@Override
	public Theatre addTheatre(Theatre theatre) {

		return adminDao.addTheatre(theatre);
	}

	@Override
	public Screen addScreen(Screen screen) {

		
		return null;
	}
	
	

}
