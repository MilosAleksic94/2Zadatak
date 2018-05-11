<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filtriraj</title>
</head>
<body>
	
	
	<form action="/TravelWEB/Filtriraj" method="post">
	<p>Unesite parametar za filtriranje</p><input type="text" name="filter">
	<input type="Submit" value="Filtriraj">
	</form>
	<c:if test="${!empty destinacije }">
	<table border="1px">
		<tr>
			<td>Drzava</td>
			<td>Grad</td>
			<td>Broj putnika</td>
			<td>Slika</td>
		</tr>
		<c:forEach items="${destinacije}" var="dest">
		
			<tr>
				<td>${dest.drzava }</td>
				<td>${dest.grad }</td>
				<td>${dest.brojPutnika }</td>
				<td><img height="50" width="50" src="get-image/${dest.idSlike}"/></td>
			</tr>
		
		</c:forEach>
	</table>
	</c:if>
	
</body>
</html>