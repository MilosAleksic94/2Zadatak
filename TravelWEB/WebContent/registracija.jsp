<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registracija</title>
</head>
<body>
	<form action="/TravelWEB/RegistracijaServlet" method="post">
	
		<p>Ime</p><input type="text" name="ime">
		<p>Prezime</p><input type="text" name="prezime">
		<p>Email</p><input type="text" name="email">
		<p>Broj telefona</p><input type="text" name="brTelefona">
		<p>Password</p><input type="text" name="password">
		<p>Datum rodjenja</p><input type=text name="datumRodjenja">
		<input type="submit" value="Registruj se">	

	</form>
	<br>
	<form action="/TravelWEB/PretragaNeregistrovaniKorisnici" method="post">
	Pregled destinacija:<br>
	<input type="submit" value="Pregled">
	</form>
	${poruka }
</body>
</html>