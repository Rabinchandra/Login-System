<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.rabin.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="user_profile.css"/>
</head>
<body>
	<% 
		if(session.getAttribute("username") == null) {
			response.sendRedirect("index.jsp");
		}
	%>

	<% 
		User user = ((User)  session.getAttribute("user"));
	%>
	
	<div class="container">
		<h2>User Profile</h2>
		<img src="https://www.clipartmax.com/png/full/258-2582267_circled-user-male-skin-type-1-2-icon-male-user-icon.png" alt="" id="profile">
		<table>
			<tr>
				<td>Username : </td>
				<td>${user.username} </td>
			</tr>
			
			<tr>
				<td>Birthday :</td>
				<td>${user.birthday}</td>
			</tr>
			
			<tr>
				<td>Gender :</td>
				<td>${user.gender}</td>
			</tr>
			
			<tr>
				<td>Occupation :</td>
				<td>${user.occupation}</td>
			</tr>
			
			<tr>
				<td>Address :</td>
				<td>${user.address}</td>
			</tr>
		</table>
		
		</div>
		
		<form action="logout" method="post">
			<button type="submit" id="logout-btn">Logout</button>
		</form>
	</div>
</body>
</html>