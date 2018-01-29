package com.accolite.ticketbooking.api.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataAccessObject {

	private static Connection conn;
	private DataAccessObject() {
		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/mtbs_database";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("connection !");
		} catch (Exception e) {
			System.out.println("Exception found" + e);
			closeConnection();
		}
	}

	private static class DAOHelper {
		private static final DataAccessObject dataobject_INSTANCE = new DataAccessObject();
	}

	public static DataAccessObject getInstance() {
		return DAOHelper.dataobject_INSTANCE;
	}

	public Connection Connect() {	
		return DataAccessObject.conn;
	}

	public void closeConnection() {
		try {
			conn.close();
		} 
		catch (Exception e) {
			System.out.println("Connection close error");
		}
	}

}
