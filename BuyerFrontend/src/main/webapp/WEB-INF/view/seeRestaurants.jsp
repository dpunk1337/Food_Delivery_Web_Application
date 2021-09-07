<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Restaurants In Your City</h1>
<table border="2" width="70%" cellpadding="2">
	<c:forEach var="restaurant" items="${restaurants}">
		<tr>
			<td><a href="seeRestaurant?mobileNumber=${restaurant.mobileNumber}">${restaurant.name}</a></td>
		</tr>
	</c:forEach>
</body>
</html>