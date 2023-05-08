package com.rabin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	String username;
	String password;
	ResultSet res;
	Connection con;
	
	LoginDao(String uname, String pwd) {
		username = uname;
		password = pwd;
		
		// Established connection with the database
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/users";
			String db_uname = "root";
			String db_pwd = "lake";
			
			con = DriverManager.getConnection(url, db_uname, db_pwd);
		}
		
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	boolean exists() {
		try {
			String query = "SELECT * FROM users_credentials WHERE username = ? AND password = ?";
			PreparedStatement smt = con.prepareStatement(query);
			
			// Setting values
			smt.setString(1, username);
			smt.setString(2, password);
			
			res = smt.executeQuery();
			if(res.next()) {
				return true;
			}
			
			return false;
		}
		
		catch(Exception e) {
			System.out.println(res);
			return false;
		}
		
	}
	
	User getUserDetails() {
		try {
			String query = "SELECT * FROM users_details WHERE username = ?";
			PreparedStatement smt = con.prepareStatement(query);
			smt.setString(1, username);
			
			ResultSet res = smt.executeQuery();
			
			if(res.next()) {
				String birthday = res.getString("birthday"); 
				String gender = res.getString("gender");
				String occupation = res.getString("occupation");
				String address = res.getString("address");
				
				User user = new User(username, birthday, gender, occupation, address);
				
				return user;
			}
			
			return (new User("", "", "", "", ""));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return (new User("", "", "", "", ""));
		}
		
	}
}
