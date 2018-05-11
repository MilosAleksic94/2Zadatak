<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>
</head>
<body>
	<form action="/TravelWEB/LoginServlet" method="post">
		<p>Email:
		<p><input type="text" name="email">
		<p>Password:
		<p><input type="password" name="password">
		<input type="submit" value="LogIn">
	</form>
	${poruka }
</body>
</html>