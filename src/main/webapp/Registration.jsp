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
		String nameerror = (String) request.getAttribute("nameerror");
		String emailerror = (String) request.getAttribute("emailerror");
		String passworderror = (String) request.getAttribute("passworderror");
	%>

	<h1>Registration form</h1><br>
	
	<form action="RegistrationController" method="post"><br>
		Name: <input type="text" name="name" value="${user.name}"><span><%=nameerror==null?"":nameerror %></span><br>
		Email: <input type="email" name="email" value="${user.email}"><span><%=emailerror==null?"":emailerror %></span><br>
		Password: <input type="password" name="password"><br>
		<input type="submit" value="Submit">
	</form>
	<br>
	
	<!-- ${xyz} -->
	
	
</body>
</html>