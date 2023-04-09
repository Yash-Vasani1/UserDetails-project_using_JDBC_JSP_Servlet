<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Search User By Name !!</h1>
	<form action = "SearchUserController" method = "post">
		Name: <input type="text" name = "name" placeholder="Enter name pattern">
		<input type="submit" value="Submit">
	</form>
</body>
</html>