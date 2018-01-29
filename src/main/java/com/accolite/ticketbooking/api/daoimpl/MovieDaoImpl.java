package com.accolite.ticketbooking.api.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.accolite.ticketbooking.api.dao.MovieDao;
import com.accolite.ticketbooking.api.databaseconnection.DataAccessObject;
import com.accolite.ticketbooking.api.model.Movie;
import com.accolite.ticketbooking.api.model.Profile;
import com.accolite.ticketbooking.api.model.Screen;
import com.accolite.ticketbooking.api.model.ScreenShows;
import com.accolite.ticketbooking.api.model.Theatre;

public class MovieDaoImpl implements MovieDao{

	private Connection connection;
	
	 public MovieDaoImpl() {
	
		connection = DataAccessObject.getInstance().Connect();
	}
	@Override
	public List<Movie> getMoviesByCity(String city) {
		
		PreparedStatement preparedstmnt=null;
		ResultSet rs=null;
		List<Movie> movies=new ArrayList<Movie>();
		try {
			preparedstmnt = connection.prepareStatement("select * from movies where movie_id in (select distinct(s.movie_id_fk) as ids from theatre t,screen_shows s where t.theatre_id=s.theatre_id_fk and t.theatre_city=?");
			preparedstmnt.setString(1,city);
			
			 rs=preparedstmnt.executeQuery();
			while(rs.next())
				{
				Movie movie=new Movie();
				movie.setMovieId(rs.getLong(1));
				movie.setMovieName(rs.getString(2));
				movie.setMovieRating(rs.getFloat(3));
				movie.setMovieGenre(rs.getString(4));
				movie.setCast(rs.getString(5));
				movie.setMovieDirector(rs.getString(6));
				movie.setDuration(rs.getTime(7).toLocalTime());
				movies.add(movie);
				}
			preparedstmnt.close();
			rs.close();
			
			return movies;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		
	}
	@Override
	public List<Theatre> getTheatresByMovieAndCity(String city, long movieId) {
		// TODO Auto-generated method stub
		PreparedStatement preparedstmnt=null;
		ResultSet rs=null;
		List<Theatre> theatres=new ArrayList<Theatre>();
		try {
			preparedstmnt = connection.prepareStatement("select * from theatre where theatre_id in (select distinct(s.theatre_id_fk) as ids from screen_shows s where s.movie_id_fk=?) and theatre_city=?");
			preparedstmnt.setLong(1,movieId);
			preparedstmnt.setString(2,city);
			
			 rs=preparedstmnt.executeQuery();
			while(rs.next())
				{
				Theatre theatre=new Theatre();
				theatre.setTheatreId(rs.getLong(1));
				theatre.setTheatreName(rs.getString(2));
				theatre.setTheatreAddress(rs.getString(3));
				theatre.setTheatreCity(rs.getString(4));
				theatres.add(theatre);
				}
			preparedstmnt.close();
			rs.close();
			
			return theatres;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;


	}
	@Override
	public List<ScreenShows> getShowsByTheatreAndScreenAndMovie(long movieId, String screenId, long theatreId) {
		PreparedStatement preparedstmnt=null;
		ResultSet rs=null;
		List<ScreenShows> shows=new ArrayList<ScreenShows>();
		try {
			preparedstmnt = connection.prepareStatement("select * from screen_shows where screen_id_fk=? and movie_id_fk=? and theatre_id_fk=? ");
			preparedstmnt.setString(1, screenId);
			preparedstmnt.setLong(2,movieId);
			preparedstmnt.setLong(3,theatreId);
			
			 rs=preparedstmnt.executeQuery();
			while(rs.next())
				{
				ScreenShows screenShows=new ScreenShows();
				screenShows.setShowId(rs.getLong(1));
				screenShows.setTheatreId(rs.getLong(2));
				screenShows.setScreenId(rs.getString(3));
				screenShows.setStartTime(rs.getTime(4).toLocalTime());
				screenShows.setDuration(rs.getTime(5).toLocalTime());
				screenShows.setStartDate(rs.getDate(6).toLocalDate());
				screenShows.setEndDate(rs.getDate(7).toLocalDate());
				screenShows.setMovieId(rs.getLong(8));
				shows.add(screenShows);
				}
			preparedstmnt.close();
			rs.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shows;

		
		
	}
	
	
	@Override
	public List<Screen> getScreensByTheatreAndMovie(long theatreId, long movieId) {
		PreparedStatement preparedstmnt=null;
		ResultSet rs=null;
		List<Screen> screens=new ArrayList<Screen>();
		try {
			preparedstmnt = connection.prepareStatement("select * from screen where screen_id in (select distinct(s.screen_id_fk)  from screen_shows s where s.movie_id_fk=? and s.theatre_id_fk=?) ");
			preparedstmnt.setLong(1,movieId);
			preparedstmnt.setLong(2,theatreId);
			
			 rs=preparedstmnt.executeQuery();
			while(rs.next())
				{
				Screen screen=new Screen();
				screen.setScreenId(rs.getString(1));
				screen.setTheatreId(rs.getLong(2));
				screen.setNoOfRows(rs.getInt(3));
				screen.setNoOfSeats(rs.getInt(4));
				screens.add(screen);
				}
			preparedstmnt.close();
			rs.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screens;

	}

	
}
