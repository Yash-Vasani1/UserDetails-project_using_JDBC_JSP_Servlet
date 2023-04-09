package com.google.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String URLNAME = "jdbc:mysql://localhost:3306/test1";
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
	
	public static Connection getConnection()
	{
		Connection conn = null;
		
		
			try {
				Class.forName(DRIVERCLASS);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		try {
			conn=DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return conn;
	}
//	public static void main(String args[])
//	{
//		Connection conn = DBConnection.getConnection();
//		if(conn == null)
//		{
//			System.out.println("Not connected");
//		}
//		else
//		{
//			System.out.println("Connected !!");
//		}
//	}
}
