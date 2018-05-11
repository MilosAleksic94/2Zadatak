<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Komentar</title>
</head>
<body>

	<form action="/TravelWEB/OstaviKomentar" method="post">
		Grad: <input type="text" name="grad"/><br>
		Komentar: <textarea rows="10" cols="30" name="tekst"></textarea><br>
		<input type="submit" value="Ostavi komentar"/>
	</form>
	
	<br>
	
	${poruka}

</body>
</html>