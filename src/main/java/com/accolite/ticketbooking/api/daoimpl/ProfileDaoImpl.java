package com.accolite.ticketbooking.api.daoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.time.LocalDate;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.sql.Date;

import com.accolite.ticketbooking.api.dao.ProfileDao;
import com.accolite.ticketbooking.api.databaseconnection.DataAccessObject;
import com.accolite.ticketbooking.api.model.Profile;


public class ProfileDaoImpl implements ProfileDao{
	
	private Connection connection;
	
	 public ProfileDaoImpl() {
	
		connection = DataAccessObject.getInstance().Connect();
	}
	
	@Override
	public Profile login(String email, String password) {
		Profile profile=null;
		StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
	    decryptor.setPassword("aeroplane");  
	    

		PreparedStatement preparedstmnt=null;
		ResultSet rs=null;
		try {
			preparedstmnt = connection.prepareStatement("select * from profile where email=?");
			preparedstmnt.setString(1,email);
			//preparedstmnt.setString(2, encryptPass);
			 rs=preparedstmnt.executeQuery();
			if(rs.next())
				{
				profile=new Profile();
				profile.setProfileId(rs.getLong(1));
				profile.setFirstName(rs.getString(4));
				profile.setType(rs.getString(8));
				profile.setLastName(rs.getString(5));
				profile.setEmail(rs.getString(3));
				String dePass=decryptor.decrypt(rs.getString(2));
				System.out.println("Decrypted text is: " + dePass);
				if(dePass.equals(password)) {
					return profile;
				}
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

	@Override
	public Profile register(Profile profile) {
		
		String pass=profile.getPassword();
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
	    encryptor.setPassword("aeroplane");        
	    String encryptPass = encryptor.encrypt(pass);

		PreparedStatement preparedstmnt=null;
		ResultSet rs=null;
		try {
			preparedstmnt = connection.prepareStatement("insert into profile (email,password,fName,lName,contact_number,dob,type) values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			preparedstmnt.setString(1,profile.getEmail());
			preparedstmnt.setString(2,encryptPass);
			preparedstmnt.setString(3, profile.getFirstName());
			preparedstmnt.setString(4, profile.getLastName());
			preparedstmnt.setLong(5,profile.getContactNo() );
			preparedstmnt.setDate(6,Date.valueOf(profile.getDob()));
			preparedstmnt.setString(7, profile.getType());
			 preparedstmnt.executeUpdate();
			 rs=preparedstmnt.getGeneratedKeys();
			if(rs!=null && rs.next())
				{
				profile.setProfileId(rs.getLong(1));
			return profile;
				}
			preparedstmnt.close();
			//rs.close();
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Profile update(String fieldName, Object fieldValue,long userId) {
		// TODO Auto-generated method stub
		
		PreparedStatement preparedstmnt=null;
		ResultSet rs=null;
		String sql="";
		Profile profile=null;
		try {
			switch(fieldName)
			{
			case "contact_number": sql="update profile set contact_number=? where user_Id=?";
			preparedstmnt=connection.prepareStatement(sql);
			preparedstmnt.setLong(1, (long)fieldValue);
			preparedstmnt.setLong(2,userId);
			break;
			case "email":sql="update profile set email=? where user_Id=?";
			preparedstmnt.setString(1, (String)fieldValue);
			preparedstmnt.setLong(2,userId);
			break;
			case "dob":sql="update profile set dob=? where user_Id=?";
			preparedstmnt.setDate(1, Date.valueOf((LocalDate)fieldValue));
			preparedstmnt.setLong(2,userId);
			break;
			case "password":sql="update profile set password=? where user_Id=?";
			preparedstmnt.setString(1, (String)fieldValue);
			preparedstmnt.setLong(2,userId);
			break;
			}
			 preparedstmnt.executeUpdate(sql);
			 sql="select * from profile where user_Id=?";
			 preparedstmnt.setLong(2,userId);
			
			 rs= preparedstmnt.executeQuery(sql);
			if(rs.next())
			{
				profile=new Profile();
				profile.setProfileId(rs.getLong(1));
				profile.setPassword(rs.getString(2));
				profile.setEmail(rs.getString(3));
				profile.setFirstName(rs.getString(4));
				profile.setLastName(rs.getString(5));
				profile.setContactNo(rs.getLong(6));
				profile.setDob(rs.getDate(7).toLocalDate());
				profile.setType(rs.getString(8));
			}
			preparedstmnt.close();
			rs.close();
			return profile;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	
	
}
