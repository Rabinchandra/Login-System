package com.rabin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignUpDao {
	String username;
	String password;
	String birthday;
	String address;
	String gender;
	String occupation;
	
	Connection con;
	
	public SignUpDao(String username, String password, String birthday, String address, String gender,
			String occupation) {
		super();
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.address = address;
		this.gender = gender;
		this.occupation = occupation;
		
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
	
	boolean insertDetails() {
		// Established connection with the database
		try {
			
			String query_1 = "INSERT INTO users_credentials VALUES(?, ?)";
			String query_2 = "INSERT INTO users_details VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement smt_1 = con.prepareStatement(query_1);
			PreparedStatement smt_2 = con.prepareStatement(query_2);
			
			// user credentials
			smt_1.setString(1, username);
			smt_1.setString(2, password);
			
			//  user details
			smt_2.setString(1, username);
			smt_2.setString(2, birthday);
			smt_2.setString(3, gender);
			smt_2.setString(4, occupation);
			smt_2.setString(5, address);
			
			int smt_1_result = smt_1.executeUpdate();
			int smt_2_result = smt_2.executeUpdate();
			
			if(smt_1_result == 1 && smt_2_result == 1) {
				return true;
			}

			return false;
		}
				
		catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
			return false;
		}
	}
	
	boolean exists() {
		try {
			String query = "SELECT * FROM users_credentials WHERE username = ?";
			PreparedStatement smt = con.prepareStatement(query);
			
			// Setting values
			smt.setString(1, username);
			
			ResultSet res = smt.executeQuery();
			if(res.next()) {
				return true;
			}
			
			return false;
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}
}
