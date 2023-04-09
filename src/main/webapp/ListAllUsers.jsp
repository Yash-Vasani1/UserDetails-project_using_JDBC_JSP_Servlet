<%@page import="com.google.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users") ;
	%>
	
	<table border=1>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th colspan=3>Action</th>
		</tr>
		
		<%
			for(UserBean user : users)
			{
		%>
		
		<tr>
			<td><%= user.getId() %></td>
			<td><%= user.getName() %></td>
			<td><%= user.getEmail() %></td>
			<td><%= user.getPassword() %></td>
			<td><a href="DeleteController?id=<%=user.getId()%>">Delete</a></td>
			<td><a href="LoginController?id=<%=user.getId()%>">View</a></td>
			<td><a href="EditUserController?id=<%= user.getId() %>">Edit</a>
		</tr>
		<%
		}
		%>
	</table>
	
</body>
</html>