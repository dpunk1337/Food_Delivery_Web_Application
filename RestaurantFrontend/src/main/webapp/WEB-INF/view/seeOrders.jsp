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
<h1>Orders</h1>
<table border="2" width="70%" cellpadding="2">
	<tr><th>Order Id</th><th>Items</th><th>Status</th><th></th></tr>
	<c:forEach var="order" items="${orders}">
		<tr>
			<td>${order.orderId}</td>
			<td>${order.items}</td>
			<td>${order.status}</td>
			<td><a href="markAsPickedUp/${order.orderId}">Mark As Picked Up</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>