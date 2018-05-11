<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pretraga destinacija</title>
</head>
<body>
	
	
	<form action="/TravelWEB/PretragaRegistrovani" method="post">
	<p>Unesite drzavu za pretragu</p><input type="text" name="drzava">
	<input type="Submit" value="Pretrazi">
	</form>
	<c:if test="${!empty destinacije }">
	<table border="1px">
		<tr>
			<td>Drzava</td>
			<td>Grad</td>
			<td>Broj putnika</td>
			<td>Slika</td>
			<td>Ponuda</td>
		</tr>
		<c:forEach items="${destinacije}" var="dest">
		
			<tr>
				<td>${dest.drzava }</td>
				<td>${dest.grad }</td>
				<td>${dest.brojPutnika }</td>
				<td><img height="100" width="100" src="get-image/${dest.slika}"/></td>
				<td><a href="">Ponuda</a>
			</tr>
		
		</c:forEach>
	</table>
	</c:if>
	
</body>
</html>