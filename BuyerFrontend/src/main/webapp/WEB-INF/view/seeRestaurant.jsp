<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Restaurant Menu</h1>
<form:form modelAttribute="orderItems" action="placeOrder?mobileNumber=${mobileNumber}" method="POST">
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Dish</th><th>Price</th><th>Quantity</th></tr>
	<c:forEach var="orderItem" items="${orderItems.orderItemsList}" varStatus="status">
		<tr>
			<td>${orderItem.name}</td>
			<td>Rs.${orderItem.price}</td>
			<td>
			<form:hidden path="orderItemsList[${status.index}].dishId" name="dishId" id="dishId" value="${orderItem.dishId}" />
			<form:hidden path="orderItemsList[${status.index}].name" name="name" id="name" value="${orderItem.name}" />
			<form:input path="orderItemsList[${status.index}].quantity" name="quantity" id="quantity" value="${orderItem.quantity}" />
			<form:hidden path="orderItemsList[${status.index}].price" name="price" id="price" value="${orderItem.price}" />
			</td>
		</tr>
	</c:forEach>
	</table>
	<input type="submit" value="Place Order"/>
</form:form>

</body>
</html>