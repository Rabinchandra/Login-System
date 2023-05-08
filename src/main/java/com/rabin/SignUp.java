package com.rabin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/signup")

public class SignUp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// To get the body which is in JSON
		BufferedReader reader = request.getReader();
		StringBuilder sb = new StringBuilder();
		String line;
				
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
				
		String jsonString = sb.toString();
				
		// To parse the JSON
		JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
				
		// Get the username and password from json object
		String username = jsonObject.getString("username");
		String password = jsonObject.getString("password");
		String birthday = jsonObject.getString("birthday");
		String address = jsonObject.getString("address");
		String gender = jsonObject.getString("gender");
		String occupation = jsonObject.getString("occupation");
		
		SignUpDao signupdao = new SignUpDao(username, password, birthday, address, gender, occupation);
		
		// Set response type to JSON
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		
	    // Create gson object
	    Gson gson = new Gson();
	    
		// user already exists
		if(signupdao.exists()) {
			ResponseToClient obj = new ResponseToClient("User Already Exists", true);
		    
			// Convert Java object to JSON
			String json = gson.toJson(obj);  
		    response.getWriter().write(json);
		}
		
		else if(signupdao.insertDetails()) {
			ResponseToClient obj = new ResponseToClient("Successfully :)", false);

			// Convert Java object to JSON
			String json = gson.toJson(obj);
		    response.getWriter().write(json);
		} 
		else {
			ResponseToClient obj = new ResponseToClient("Something went wrong!", true);
		    
			// Convert Java object to JSON
			String json = gson.toJson(obj);
		    response.getWriter().write(json);
		}
	}

}
