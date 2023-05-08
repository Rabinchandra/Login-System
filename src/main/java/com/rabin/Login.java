package com.rabin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.google.gson.Gson;

@WebServlet("/login")
public class Login extends HttpServlet {
	
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
		
		// To Verify the login credential
		 LoginDao logindao = new LoginDao(username, password);
		
		// Create session
		HttpSession session = request.getSession();
				
		// if the user exists
		if( logindao.exists() ) {
			session.setAttribute("username", username);
			
			User user = logindao.getUserDetails();
			session.setAttribute("user", user);

			// Create a Gson instance
			Gson gson = new Gson();
			ResponseToClient obj = new ResponseToClient("no", false);
			
			 // Convert Java object to JSON
			 String json = gson.toJson(obj);
			// Set response type to JSON
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    
			// response.sendRedirect("user_profile.jsp");
		} else {
			session.removeAttribute("username");
			
			 ResponseToClient obj = new ResponseToClient("Invalid Credentials", true);
			    
			 // Convert Java object to JSON
			 Gson gson = new Gson();
			 String json = gson.toJson(obj);
			    
			// Set response type to JSON
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
	}
}



