<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dodavanje ponude</title>
</head>
<body>
<form action="/TravelWEB/DodajPonudu" method="post">
	<p>Unesite cenu</p><input type="text" name="cena">
	<p>Unesite trajanje</p><input type="text" name="trajanje">
	<p>Unesite broj saputnika</p><input type="text" name="brojSaputnika">
	<p>Unesite nacin putovanja</p><input type="text" name="nacinPutovanja">
	<p>Unesite opis smestaja</p><input type="text" name="opisSmjestaja"><br>
	<p>Unesite naziv destinacije</p><input type="text" name="naziv"><br>	
	<input type="submit" value="Dodaj ponudu">
</form>
	${poruka}  
</body>
</html>