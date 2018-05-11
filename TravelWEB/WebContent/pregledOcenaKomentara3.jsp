<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pregled ocena</title>
</head>
<body>
<%--
<c:forEach items="${ocene}" var="o">
<c:forEach items="${listaKor1 }" var="l">
<c:forEach items="${listaKor2 }" var="j">
  	<input type="checkbox" name="ocena" value="${o.ocena }">${l.ime } ${l.prezime } ocenio ${j.ime } ${j.prezime } Ocena: ${o.ocena }<br>
  </c:forEach>
  </c:forEach>
  </c:forEach>
  --%>
  <c:forEach items="${ocene }" var="o">
  <input type="checkbox" name="ocena" value="${o.ocena }">${o.korisnik1.ime }Ocena: ${o.ocena }<br>
  </c:forEach>
</body>
</html>