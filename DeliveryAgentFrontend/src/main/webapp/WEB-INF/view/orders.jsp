<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Orders</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>OrderId</th><th>Items</th><th>Status</th><th>Pickup Address</th><th>Delivery Address</th></tr>
    <c:forEach var="order" items="${orders}"> 
    <tr>
    <td>${order.orderId}</td>
    <td>${order.items}</td>
    <td>${order.status}</td>
    <td>${order.restaurantAddress}</td>
	<td>${order.buyerAddress}</td>
    
    </tr>
    </c:forEach>
    </table>
    <br/>

</body>
</html>