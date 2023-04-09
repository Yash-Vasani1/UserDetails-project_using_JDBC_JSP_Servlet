<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Your Data</h1><br><br>
	
	<form action="EditUserController" method="post">
		<input type="hidden" value=${user.id } name="id">
		Name: <input type="text" value=${user.name } name = "name"><br>
		Email: <input type="email" value=${user.email } name = "email"><br>
		Password: <input type="password" value=${user.password } name = "password"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>