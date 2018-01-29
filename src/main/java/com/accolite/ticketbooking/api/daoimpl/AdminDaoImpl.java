package com.accolite.ticketbooking.api.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.accolite.ticketbooking.api.dao.AdminDao;
import com.accolite.ticketbooking.api.databaseconnection.DataAccessObject;
import com.accolite.ticketbooking.api.model.Movie;
import com.accolite.ticketbooking.api.model.Profile;
import com.accolite.ticketbooking.api.model.Screen;
import com.accolite.ticketbooking.api.model.ScreenShows;
import com.accolite.ticketbooking.api.model.Theatre;
	
public class AdminDaoImpl implements AdminDao{

	private Connection connection;
	
	 public AdminDaoImpl() {
	
		connection = DataAccessObject.getInstance().Connect();
	}
	@Override
	public ScreenShows addShow(ScreenShows screenShows) {
		// TODO Auto-generated method stub
		PreparedStatement preparedstmnt=null;
		ResultSet rs=null;
		try {
			preparedstmnt = connection.prepareStatement("insert into screen_shows (theatre_id_fk,screen_id_fk,show_start_time,duration,show_start_date,show_end_date,movie_id_fk) values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			preparedstmnt.setLong(1, screenShows.getTheatreId());
			preparedstmnt.setLong(2, screenShows.getScreenId());
			preparedstmnt.setTime(3,java.sql.Time.valueOf(screenShows.getStartTime() ));
			preparedstmnt.setTime(4, java.sql.Time.valueOf(screenShows.getDuration() ));
			preparedstmnt.setDate(5,java.sql.Date.valueOf(screenShows.getStartDate()));
			preparedstmnt.setDate(6, java.sql.Date.valueOf(screenShows.getEndDate()));
			preparedstmnt.setLong(7, screenShows.getMovieId());
			preparedstmnt.executeUpdate();
			rs=preparedstmnt.getGeneratedKeys();
			if(rs!=null && rs.next())
				{
				screenShows.setShowId(rs.getLong(1));
			return screenShows;
				}
			preparedstmnt.close();
			connection.close();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String removeShow(long showId) {
		// TODO Auto-generated method stub
		PreparedStatement preparedstmnt=null;
		
		try {
			preparedstmnt = connection.prepareStatement("Delete from screen_shows where show_id=?");
			
			 int i=preparedstmnt.executeUpdate();
			if(i==1)
				{
				return "Show deleted successfully";
				}
			preparedstmnt.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	
	}

	@Override
	public List<ScreenShows> getShows(long theatreId, long screenId) {
		// TODO Auto-generated method stub
PreparedStatement preparedstmnt=null;
	ResultSet rs=null;
	List<ScreenShows> shows=new ArrayList<ScreenShows>();
		try {
			preparedstmnt = connection.prepareStatement("select * from screen_shows where theatre_id_fk=? and screen_id_fk=?");
			
			 rs=preparedstmnt.executeQuery();
			while(rs.next())
				{
				ScreenShows s=new ScreenShows();
				s.setShowId(rs.getLong(1));
				s.setTheatreId(rs.getLong(2));
				s.setScreenId(rs.getInt(3));
				s.setStartTime(rs.getTime(4).toLocalTime());
				s.setDuration(rs.getTime(5).toLocalTime());
				s.setStartDate(rs.getDate(6).toLocalDate());
				s.setEndDate(rs.getDate(7).toLocalDate());
				s.setMovieId(rs.getLong(8));
				shows.add(s);
				
				}
			preparedstmnt.close();
		
		
		
	
	}catch(Exception e)
		{
		e.printStackTrace();
		}
		return shows;
	}

	@Override
	public ScreenShows updateShow(long theatreId, long screenId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile addAdmin(Profile profile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie addMovie(Movie movie) {
		

		PreparedStatement preparedstmnt=null;
	
		try {
			preparedstmnt = connection.prepareStatement("insert into movies (movie_name,movie_rating,movie_cast,movie_genre,movie_director,movie_duration,movie_pic_url) values(?,?,?,?,?,?,?)");
			preparedstmnt.setString(1, movie.getMovieName());
			preparedstmnt.setFloat(2, movie.getMovieRating());
			preparedstmnt.setString(3,movie.getCast());
			preparedstmnt.setString(4, movie.getMovieGenre());
			preparedstmnt.setString(5, movie.getMovieDirector());
			preparedstmnt.setTime(6, java.sql.Time.valueOf(movie.getDuration() ));
			preparedstmnt.setString(7, movie.getMoviePicUrl());
			 int rs=preparedstmnt.executeUpdate();
			if(rs==1)
				{
			return movie;
				}
			preparedstmnt.close();
			connection.close();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Theatre> getTheatres(String city) {
		// TODO Auto-generated method stub
		PreparedStatement preparedstmnt=null;
		ResultSet rs=null;
		List<Theatre> theatres=null;
		try {
			preparedstmnt = connection.prepareStatement("select * from theatre where city=?");
			preparedstmnt.setString(1,city);
			theatres=new ArrayList<Theatre>();
			 rs=preparedstmnt.executeQuery();
			while(rs.next())
				{
			Theatre theatre=new Theatre();
			theatre.setTheatreId(rs.getLong(1));
			theatre.setTheatreName(rs.getString(2));
			theatre.setTheatreAddress(rs.getString(3));
			theatre.setTheatreCity(city);
				}
			preparedstmnt.close();
			rs.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theatres;
	}

	@Override
	public Theatre addTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		PreparedStatement preparedstmnt=null;
		ResultSet rs=null;
		try {
			preparedstmnt = connection.prepareStatement("insert into theatre (theatre_name,theatre_address,theatre_city) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			preparedstmnt.setString(1, theatre.getTheatreName());
			preparedstmnt.setString(2, theatre.getTheatreAddress());
			preparedstmnt.setString(3,theatre.getTheatreCity());
			
			  preparedstmnt.executeUpdate();
			  rs=preparedstmnt.getGeneratedKeys();
			if(rs!=null && rs.next())
				{
				
				
				theatre.setTheatreId(rs.getLong(1));
				
			return theatre;
				}
			preparedstmnt.close();
			connection.close();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;


	}

	@Override
	public Screen addScreen(long theatreId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
