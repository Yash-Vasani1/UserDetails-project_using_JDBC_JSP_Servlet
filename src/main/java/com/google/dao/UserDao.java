package com.google.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.bean.UserBean;
import com.google.util.DBConnection;


public class UserDao {
	
	public void addUser(UserBean ubean)
	{
		String Query = "INSERT INTO temp3(name, email, password) VALUES (?, ?, ?)";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, ubean.getName());
			pstmt.setString(2, ubean.getEmail());
			pstmt.setString(3, ubean.getPassword());
			pstmt.executeUpdate();
			
			System.out.println("Data Inserted Sucessfully !!");
//			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public UserBean authenticate(String uname, String pass)
	{
		UserBean user = null;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = null;
			String Query = "SELECT * FROM temp3 WHERE (email=? OR name=?) AND password=?";
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, uname);
			pstmt.setString(2, uname);
			pstmt.setString(3, pass);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserBean();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			}
			
			
			
			if(rs.next())
			{
				System.out.println(rs.getInt("id") + "\n" + rs.getString("name") + "\n" + rs.getString("email") + "\n" + rs.getString("password"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		
		String Query = "SELECT * FROM temp3";
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(Query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				UserBean user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return users;
	}
	
	public UserBean getUserById(int id1)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		UserBean user = null;
		
		try {
			String Query = "SELECT * FROM temp3 WHERE id=?";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, id1);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
//			return null;
		}
		return user;		
	}
	public void DeleteUser(int id1)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String Query = "DELETE FROM temp3 WHERE id = ?";
		conn = DBConnection.getConnection();
		
		try {
			pstmt= conn.prepareStatement(Query);
			pstmt.setInt(1, id1);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void EditUser(UserBean ubean)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String Query = "UPDATE temp3 SET name = ?, email = ?, password = ? WHERE id = ?";
		conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, ubean.getName());
			pstmt.setString(2, ubean.getEmail());
			pstmt.setString(3, ubean.getPassword());
			pstmt.setInt(4, ubean.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<UserBean> SearchUser(String name)
	{
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			String Query = "SELECT * FROM temp3 WHERE name LIKE ?";
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, name+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				UserBean user = new UserBean();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
}
